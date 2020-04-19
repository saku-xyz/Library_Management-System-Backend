package lk.geeks.service.impl;

import lk.geeks.dto.ForeignMemberDTO;
import lk.geeks.dto.LocalMemberDTO;
import lk.geeks.dto.LoginDetailDTO;
import lk.geeks.dto.UserDTO;
import lk.geeks.entity.User;
import lk.geeks.repostitory.UserRepository;
import lk.geeks.service.ForeignMemberService;
import lk.geeks.service.LocalMemberService;
import lk.geeks.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Transactional
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ForeignMemberService foreignMemberService;

    @Autowired
    private LocalMemberService localMemberService;

//    @Autowired
//    private PasswordEncoder encoder;
    @Override
    public boolean save(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
        return true;
    }

    @Override
    public LoginDetailDTO login(String uname, String password) {

        Optional<User> userOpt = userRepository.findById(uname);

        if(!userOpt.isPresent()){
            return null;
        }

        User user = userOpt.get();
        if(user.getPassword().equals(password) && user.getIsApprove()==true){
            if(user.getMemberType().equals("local")){
                LocalMemberDTO localMemberDTO = localMemberService.findById(user.getNic());
                LoginDetailDTO loginDetailDTO = new LoginDetailDTO(localMemberDTO.getNIC(),localMemberDTO.getFullname(),user.getMemberType());
                return loginDetailDTO;

            }else{
                ForeignMemberDTO foreignMemberDTO= foreignMemberService.findById(user.getNic());
                LoginDetailDTO loginDetailDTO = new LoginDetailDTO(foreignMemberDTO.getNIC(),foreignMemberDTO.getFullname(),user.getMemberType());
                return loginDetailDTO;
            }
        }else {
            return null;
        }
    }

    @Override
    public boolean approveMemebr(String NIC) {
        List<User> users = userRepository.findAll();


        users.forEach(user -> {
            if(user.getNic().equals(NIC)){
                user.setIsApprove(true);
                try {
                    sendEmail(NIC);
                } catch (MessagingException e) {
                    e.printStackTrace();

                }
                return;
            }
        });

        return true;
    }

    @Override
    public User findByID(String uname) {
        return userRepository.findById(uname).get();
    }


    private  void  sendEmail(String NIC) throws MessagingException {

        ForeignMemberDTO member = foreignMemberService.findById(NIC);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("SLlibrary1234@gmail.com", "SL.Lib01234");
            }
        });

        Message msg = new MimeMessage(session);
         msg.setFrom(new InternetAddress("SLlibrary1234@gmail.com",false));
         msg.setRecipient(Message.RecipientType.TO,new InternetAddress(member.getEmail()));
         msg.setSubject("SriLanka National Library");
         msg.setContent("Congratulations, Your request accepted by National Library of Sri Lanka. Now you can login to our system using your user name and password ","text/html");
         msg.setSentDate(new Date());
         Transport.send(msg);

    }


}
