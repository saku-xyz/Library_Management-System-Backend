package lk.geeks.service.impl;

import lk.geeks.dto.ItemDTO;
import lk.geeks.dto.LocalBookBrrowDTO;
import lk.geeks.dto.LocalMemberDTO;
import lk.geeks.entity.ForeignMemberBrrow;
import lk.geeks.entity.Item;
import lk.geeks.entity.LocalBookBrrow;
import lk.geeks.entity.LocalMember;
import lk.geeks.repostitory.LocalMemberBrrowRepository;
import lk.geeks.repostitory.LocalMemberRepository;
import lk.geeks.service.LocalBookBrrowService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class LocalBookBrrowServiceImpl implements LocalBookBrrowService {

    @Autowired
    private LocalMemberBrrowRepository localMemberBrrowRepository;

    @Override
    public List<LocalBookBrrowDTO> getAll() {

        List<LocalBookBrrow> localBookBrrows = localMemberBrrowRepository.findAll();

        List<LocalBookBrrowDTO> localBookBrrowDTOS  = new ArrayList<>();

        localBookBrrows.forEach(localBookBrrow -> {
            LocalBookBrrowDTO localBookBrrowDTO = new LocalBookBrrowDTO();
            LocalMemberDTO localMemberDTO = new LocalMemberDTO();
            ItemDTO itemDTO = new ItemDTO();
            BeanUtils.copyProperties(localBookBrrow.getLocalMember(),localMemberDTO);
            BeanUtils.copyProperties(localBookBrrow.getItem(),itemDTO);
            BeanUtils.copyProperties(localBookBrrow,localBookBrrowDTO);
            localBookBrrowDTO.setItemDTO(itemDTO);
            localBookBrrowDTO.setLocalMemberDTO(localMemberDTO);
            localBookBrrowDTOS.add(localBookBrrowDTO);
        });

        return localBookBrrowDTOS;
    }

    @Override
    public int save(LocalBookBrrowDTO localBookBrrowDTO) {

        LocalBookBrrow localBookBrrow = new LocalBookBrrow();
        Item item = new Item();
        LocalMember localMember = new LocalMember();
        ItemDTO itemDTO = localBookBrrowDTO.getItemDTO();
        LocalMemberDTO localMemberDTO = localBookBrrowDTO.getLocalMemberDTO();

        BeanUtils.copyProperties(localMemberDTO,localMember);
        BeanUtils.copyProperties(itemDTO,item);
        BeanUtils.copyProperties(localBookBrrowDTO,localBookBrrow);
        localBookBrrow.setItem(item);
        localBookBrrow.setLocalMember(localMember);
        return localMemberBrrowRepository.save(localBookBrrow).getBrrowID();


    }

    @Override
    public LocalBookBrrowDTO findByID(int ID) {
        Optional<LocalBookBrrow> byId = localMemberBrrowRepository.findById(ID);
        if(byId.isPresent()){
            LocalBookBrrow localBookBrrow = byId.get();
            Item item = localBookBrrow.getItem();
            LocalMember localMember =
                    localBookBrrow.getLocalMember();
            LocalBookBrrowDTO localBookBrrowDTO = new LocalBookBrrowDTO();
            ItemDTO itemDTO = new ItemDTO();
            LocalMemberDTO localMemberDTO = new LocalMemberDTO();
            BeanUtils.copyProperties(localBookBrrow,localBookBrrowDTO);
            BeanUtils.copyProperties(item,itemDTO);
            BeanUtils.copyProperties(localMember,localMemberDTO);
            localBookBrrowDTO.setItemDTO(itemDTO);
            localBookBrrowDTO.setLocalMemberDTO(localMemberDTO);
            return localBookBrrowDTO;
        }
        return null;
    }

    @Override
    public boolean delete(int ID) {
        localMemberBrrowRepository.deleteById(ID);
        return true;
    }

    @Override
    public boolean update(int ID, LocalBookBrrowDTO localBookBrrowDTO) {
        LocalBookBrrow localBookBrrow = localMemberBrrowRepository.findById(ID).get();
        BeanUtils.copyProperties(localBookBrrowDTO,localBookBrrow);
        return true;
    }

    @Override
    public boolean returnBook(int ID) {
        LocalBookBrrow localBookBrrow = localMemberBrrowRepository.findById(ID).get();
        localBookBrrow.setReturn(true);
        return true;
    }

    @Override
    public List<LocalBookBrrowDTO> notReturn() {
        List<LocalBookBrrow> localBookBrrows = localMemberBrrowRepository.findAll();

        List<LocalBookBrrowDTO> notRetun = new ArrayList<>();
        localBookBrrows.forEach(localBookBrrow -> {
            if(localBookBrrow.isReturn()==false){
                LocalBookBrrowDTO localBookBrrowDTO = new LocalBookBrrowDTO();
                ItemDTO itemDTO = new ItemDTO();
                LocalMemberDTO localMemberDTO = new LocalMemberDTO();
                BeanUtils.copyProperties(localBookBrrow,localBookBrrowDTO);
                BeanUtils.copyProperties(localBookBrrow.getItem(),itemDTO);
                BeanUtils.copyProperties(localBookBrrow.getLocalMember(),localMemberDTO);
                localBookBrrowDTO.setItemDTO(itemDTO);
                localBookBrrowDTO.setLocalMemberDTO(localMemberDTO);
                notRetun.add(localBookBrrowDTO);
            }
        });
        return notRetun;

    }

    @Override
    public List<LocalBookBrrowDTO> findByDate(String date) {

        List<LocalBookBrrow> localBookBrrows = localMemberBrrowRepository.findAll();

        List<LocalBookBrrowDTO> byDate = new ArrayList<>();
        localBookBrrows.forEach(localBookBrrow -> {
            if(localBookBrrow.isReturn()==false && localBookBrrow.getRetrunDate().toString().equals(date)){
                LocalBookBrrowDTO localBookBrrowDTO = new LocalBookBrrowDTO();
                ItemDTO itemDTO = new ItemDTO();
                LocalMemberDTO localMemberDTO = new LocalMemberDTO();
                BeanUtils.copyProperties(localBookBrrow,localBookBrrowDTO);
                BeanUtils.copyProperties(localBookBrrow.getItem(),itemDTO);
                BeanUtils.copyProperties(localBookBrrow.getLocalMember(),localMemberDTO);
                localBookBrrowDTO.setItemDTO(itemDTO);
                localBookBrrowDTO.setLocalMemberDTO(localMemberDTO);
                byDate.add(localBookBrrowDTO);
            }
        });
        return byDate;


    }
}
