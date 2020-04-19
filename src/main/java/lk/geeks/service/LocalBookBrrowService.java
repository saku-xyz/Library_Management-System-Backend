package lk.geeks.service;

import lk.geeks.dto.LocalBookBrrowDTO;
import lk.geeks.entity.ForeignMemberBrrow;

import java.util.List;

public interface LocalBookBrrowService {


    List<LocalBookBrrowDTO> getAll();

    int save(LocalBookBrrowDTO localBookBrrowDTO);

    LocalBookBrrowDTO findByID(int ID);

    boolean delete(int ID);

    boolean update(int ID,LocalBookBrrowDTO localBookBrrowDTO);

    boolean returnBook(int ID);

//    List<LocalBookBrrowDTO> returnBook();

    List<LocalBookBrrowDTO> notReturn();

    List<LocalBookBrrowDTO> findByDate(String date);




}
