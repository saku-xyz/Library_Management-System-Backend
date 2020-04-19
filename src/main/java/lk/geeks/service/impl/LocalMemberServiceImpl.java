package lk.geeks.service.impl;

import lk.geeks.dto.LocalMemberDTO;
import lk.geeks.dto.UserDTO;
import lk.geeks.entity.LocalMember;
import lk.geeks.repostitory.LocalMemberRepository;
import lk.geeks.service.LocalMemberService;
import lk.geeks.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class LocalMemberServiceImpl implements LocalMemberService {

    @Autowired
    private LocalMemberRepository localMemberRepository;

    @Autowired
    private UserService userService;
    @Override
    public boolean save(LocalMemberDTO localMemberDTO) {

        LocalMember localMember = new LocalMember();
        BeanUtils.copyProperties(localMemberDTO,localMember);
        localMemberRepository.save(localMember);

        UserDTO userDTO = new UserDTO(localMemberDTO.getUserName(), localMemberDTO.getPassword(), true, "local", localMemberDTO.getNIC());

        userService.save(userDTO);


        return true;
    }

    @Override
    public boolean update(String NIC, LocalMemberDTO localMemberDTO) {
        if(!NIC.equals(localMemberDTO.getNIC())){
            throw new RuntimeException("NICs  are Not Same");

        }
        LocalMember localMember = new LocalMember();
        BeanUtils.copyProperties(localMemberDTO,localMember);
        localMemberRepository.save(localMember);
        return true;
    }

    @Override
    public boolean delete(String NIC) {

        localMemberRepository.deleteById(NIC);
        return true;
    }

    @Override
    public List<LocalMemberDTO> findAll() {

        if(localMemberRepository.findAll().isEmpty()){
            return null;
        }
        List<LocalMemberDTO> localMemberDTOS = new ArrayList<>();
        localMemberRepository.findAll().forEach(member->{
            LocalMemberDTO localMemberDTO = new LocalMemberDTO();
            BeanUtils.copyProperties(member,localMemberDTO);
            localMemberDTOS.add(localMemberDTO);
        });

        return localMemberDTOS;

    }

    @Override
    public LocalMemberDTO findById(String NIC) {
        if(!localMemberRepository.findById(NIC).isPresent()){
            return null;
        }

        LocalMemberDTO localMemberDTO = new LocalMemberDTO();
        BeanUtils.copyProperties(localMemberRepository.findById(NIC).get(),localMemberDTO);
        return localMemberDTO;
    }
}
