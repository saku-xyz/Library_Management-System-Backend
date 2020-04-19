package lk.geeks.service;

import lk.geeks.dto.ForeignMemberDTO;

import java.util.List;

public interface ForeignMemberService {

    boolean save(ForeignMemberDTO foreignMemberDTO);

    boolean update(String NIC,ForeignMemberDTO foreignMemberDTO);

    List<ForeignMemberDTO> findAll();

    ForeignMemberDTO findById(String NIC);

    boolean delete(String NIC);

    boolean approveMember(String NIC);

    List<ForeignMemberDTO> getRequests();
}
