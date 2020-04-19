package lk.geeks.service;

import lk.geeks.dto.LocalMemberDTO;

import java.util.List;

public interface LocalMemberService {

    boolean save(LocalMemberDTO localMemberDTO);

    boolean update(String NIC, LocalMemberDTO localMemberDTO);

    boolean delete(String NIC);

    List<LocalMemberDTO> findAll();

    LocalMemberDTO findById(String NIC);




}
