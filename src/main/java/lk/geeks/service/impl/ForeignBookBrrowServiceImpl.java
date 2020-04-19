package lk.geeks.service.impl;

import lk.geeks.dto.ForeignMemberBrrowDTO;
import lk.geeks.dto.ForeignMemberDTO;
import lk.geeks.dto.ItemDTO;
import lk.geeks.entity.ForeignMember;
import lk.geeks.entity.ForeignMemberBrrow;
import lk.geeks.entity.Item;
import lk.geeks.repostitory.ForeignMemberBrrowRepository;
import lk.geeks.service.ForeignBookBrrowService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ForeignBookBrrowServiceImpl implements ForeignBookBrrowService {


    @Autowired
    private ForeignMemberBrrowRepository foreignMemberBrrowRepository;

    @Override
    public int save(ForeignMemberBrrowDTO foreignMemberBrrowDTO) {
        ForeignMember foreignMember = new ForeignMember();
        Item item = new Item();
        ForeignMemberBrrow foreignMemberBrrow = new ForeignMemberBrrow();
        BeanUtils.copyProperties(foreignMemberBrrowDTO,foreignMemberBrrow);
        BeanUtils.copyProperties(foreignMemberBrrowDTO.getItemDTO(),item);
        BeanUtils.copyProperties(foreignMemberBrrowDTO.getForeignMemberDTO(),foreignMember);
        foreignMemberBrrow.setItem(item);
        foreignMemberBrrow.setForeignMember(foreignMember);
        return foreignMemberBrrowRepository.save(foreignMemberBrrow).getBrrowID();

    }

    @Override
    public List<ForeignMemberBrrowDTO> getAll() {
        List<ForeignMemberBrrow> foreignBrrows = foreignMemberBrrowRepository.findAll();

        List<ForeignMemberBrrowDTO> foreignMemberBrrowDTOS = new ArrayList<>();

        foreignBrrows.forEach(foreignMemberBrrow -> {
            ForeignMemberBrrowDTO foreignMemberBrrowDTO = new ForeignMemberBrrowDTO();
            ItemDTO itemDTO = new ItemDTO();
            ForeignMemberDTO foreignMemberDTO = new ForeignMemberDTO();
            BeanUtils.copyProperties(foreignMemberBrrow,foreignMemberBrrowDTO);
            BeanUtils.copyProperties(foreignMemberBrrow.getItem(),itemDTO);
            BeanUtils.copyProperties(foreignMemberBrrow.getForeignMember(),foreignMemberDTO);
            foreignMemberBrrowDTO.setItemDTO(itemDTO);
            foreignMemberBrrowDTO.setForeignMemberDTO(foreignMemberDTO);
            foreignMemberBrrowDTOS.add(foreignMemberBrrowDTO);
        });

        return foreignMemberBrrowDTOS;
    }

    @Override
    public ForeignMemberBrrowDTO findByID(Integer ID) {

        if(foreignMemberBrrowRepository.findById(ID).isPresent()==true){
            ForeignMemberBrrow foreignMemberBrrow = foreignMemberBrrowRepository.findById(ID).get();
            ForeignMemberBrrowDTO foreignMemberBrrowDTO = new ForeignMemberBrrowDTO();
            ItemDTO itemDTO = new ItemDTO();
            ForeignMemberDTO foreignMemberDTO = new ForeignMemberDTO();
            BeanUtils.copyProperties(foreignMemberBrrow,foreignMemberBrrowDTO);
            BeanUtils.copyProperties(foreignMemberBrrow.getItem(),itemDTO);
            BeanUtils.copyProperties(foreignMemberBrrow.getForeignMember(),foreignMemberDTO);
            foreignMemberBrrowDTO.setItemDTO(itemDTO);
            foreignMemberBrrowDTO.setForeignMemberDTO(foreignMemberDTO);
            return foreignMemberBrrowDTO;
        }
        throw new RuntimeException("Record Not Found ! ");

    }

    @Override
    public boolean delete(Integer ID) {
        foreignMemberBrrowRepository.deleteById(ID);
        return  true;
    }

    @Override
    public boolean update(Integer ID, ForeignMemberBrrowDTO foreignMemberBrrowDTO) {
        ForeignMemberBrrow foreignMemberBrrow = foreignMemberBrrowRepository.findById(ID).get();
        BeanUtils.copyProperties(foreignMemberBrrowDTO,foreignMemberBrrow);
        return true;
    }

    @Override
    public boolean returnBoo(Integer ID) {
        foreignMemberBrrowRepository.findById(ID).get().setReturn(true);
        return true;
    }

    @Override
    public List<ForeignMemberBrrowDTO> notReturn() {
        List<ForeignMemberBrrow> foreignMemberBrrows = foreignMemberBrrowRepository.findAll();

        List<ForeignMemberBrrowDTO> foreignMemberDTOS = new ArrayList<>();
        foreignMemberBrrows.forEach(foreignMemberBrrow -> {
            ForeignMemberBrrowDTO foreignMemberBrrowDTO = new ForeignMemberBrrowDTO();
            ItemDTO itemDTO = new ItemDTO();
            ForeignMemberDTO foreignMemberDTO = new ForeignMemberDTO();
            BeanUtils.copyProperties(foreignMemberBrrow,foreignMemberBrrowDTO);
            BeanUtils.copyProperties(foreignMemberBrrow.getItem(),itemDTO);
            BeanUtils.copyProperties(foreignMemberBrrow.getForeignMember(),foreignMemberDTO);
            foreignMemberBrrowDTO.setItemDTO(itemDTO);
            foreignMemberBrrowDTO.setForeignMemberDTO(foreignMemberDTO);
            foreignMemberDTOS.add(foreignMemberBrrowDTO);
        });
        return foreignMemberDTOS;


    }

    @Override
    public List<ForeignMemberBrrowDTO> findByDate(String date) {
        List<ForeignMemberBrrow> foreignMemberBrrows = foreignMemberBrrowRepository.findAll();

        List<ForeignMemberBrrowDTO> foreignMemberDTOS = new ArrayList<>();
        foreignMemberBrrows.forEach(foreignMemberBrrow -> {
            if(foreignMemberBrrow.isReturn()==false && foreignMemberBrrow.getReturnDate().toString().equals(date)){
                ForeignMemberBrrowDTO foreignMemberBrrowDTO = new ForeignMemberBrrowDTO();
                ItemDTO itemDTO = new ItemDTO();
                ForeignMemberDTO foreignMemberDTO = new ForeignMemberDTO();
                BeanUtils.copyProperties(foreignMemberBrrow,foreignMemberBrrowDTO);
                BeanUtils.copyProperties(foreignMemberBrrow.getItem(),itemDTO);
                BeanUtils.copyProperties(foreignMemberBrrow.getForeignMember(),foreignMemberDTO);
                foreignMemberBrrowDTO.setItemDTO(itemDTO);
                foreignMemberBrrowDTO.setForeignMemberDTO(foreignMemberDTO);
                foreignMemberDTOS.add(foreignMemberBrrowDTO);
            }

        });
        return foreignMemberDTOS;
    }
}
