package lk.geeks.service.impl;

import lk.geeks.dto.ForeignMemberDTO;
import lk.geeks.dto.UserDTO;
import lk.geeks.entity.ForeignMember;
import lk.geeks.repostitory.ForeignMemberRepository;
import lk.geeks.service.ForeignMemberService;
import lk.geeks.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ForeignMemberServiceImpl implements ForeignMemberService {


    @Autowired
    private ForeignMemberRepository foreignMemberRepository;

    @Autowired
    private UserService userService;

    @Override
    public boolean save(ForeignMemberDTO foreignMemberDTO) {


        ForeignMember foreignMember = new ForeignMember();
        BeanUtils.copyProperties(foreignMemberDTO, foreignMember);
        foreignMemberRepository.save(foreignMember);
        UserDTO userDTO = new UserDTO(foreignMemberDTO.getUserName(),foreignMemberDTO.getPassword(),false,"foreign",foreignMemberDTO.getNIC());
        userService.save(userDTO);
        return true;
    }

    @Override
    public boolean update(String NIC, ForeignMemberDTO foreignMemberDTO) {


        ForeignMember foreignMember = foreignMemberRepository.findById(NIC).get();
        BeanUtils.copyProperties(foreignMemberDTO, foreignMember);
        foreignMemberRepository.save(foreignMember);
        return true;
    }

    @Override
    public List<ForeignMemberDTO> findAll() {

        List<ForeignMember> allforignMembers = foreignMemberRepository.findAll();

        if (allforignMembers.isEmpty()) {
            return null;
        }
        List<ForeignMemberDTO> foreignMemberDTOS = new ArrayList<>();
        allforignMembers.forEach(member -> {
            ForeignMemberDTO foreignMemberDTO = new ForeignMemberDTO();
            BeanUtils.copyProperties(member, foreignMemberDTO);
            foreignMemberDTOS.add(foreignMemberDTO);
        });


        return foreignMemberDTOS;
    }

    @Override
    public ForeignMemberDTO findById(String NIC) {

        if (!foreignMemberRepository.findById(NIC).isPresent()) {
            return null;
        }

        ForeignMember foreignMember = foreignMemberRepository.findById(NIC).get();
        ForeignMemberDTO foreignMemberDTO = new ForeignMemberDTO();
        BeanUtils.copyProperties(foreignMember, foreignMemberDTO);
        return foreignMemberDTO;

    }

    @Override
    public boolean delete(String NIC) {

        foreignMemberRepository.deleteById(NIC);
        return true;

    }

    @Override
    public boolean approveMember(String NIC) {

        ForeignMember foreignMember = foreignMemberRepository.findById(NIC).get();
        foreignMember.setApprove(true);
        userService.approveMemebr(NIC);
        return true;
    }

    @Override
    public List<ForeignMemberDTO> getRequests() {
        List<ForeignMember> foreignMembers = foreignMemberRepository.findAll();
        List<ForeignMemberDTO> foreignMemberDTOS = new ArrayList<>();
        foreignMembers.forEach(foreignMember -> {
            if(foreignMember.isApprove()==false){
                ForeignMemberDTO foreignMemberDTO = new ForeignMemberDTO();
                BeanUtils.copyProperties(foreignMember,foreignMemberDTO);
                foreignMemberDTOS.add(foreignMemberDTO);
            }
        });

        return foreignMemberDTOS;
    }
}
