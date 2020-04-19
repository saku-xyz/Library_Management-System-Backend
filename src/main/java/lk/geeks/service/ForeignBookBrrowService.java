package lk.geeks.service;

import lk.geeks.dto.ForeignMemberBrrowDTO;
import lk.geeks.dto.ForeignMemberDTO;

import java.util.List;

public interface ForeignBookBrrowService {

    int save(ForeignMemberBrrowDTO foreignMemberBrrowDTO);

    List<ForeignMemberBrrowDTO> getAll();

    ForeignMemberBrrowDTO findByID(Integer ID);

    boolean delete(Integer ID);

    boolean update(Integer ID, ForeignMemberBrrowDTO foreignMemberBrrowDTO);

    boolean returnBoo(Integer ID);

    List<ForeignMemberBrrowDTO> notReturn();

    List<ForeignMemberBrrowDTO> findByDate(String date);





}
