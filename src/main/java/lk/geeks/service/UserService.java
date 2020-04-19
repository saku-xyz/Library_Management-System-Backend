package lk.geeks.service;

import lk.geeks.dto.LoginDetailDTO;
import lk.geeks.dto.UserDTO;
import lk.geeks.entity.User;

public interface UserService {


    boolean save(UserDTO userDTO);

    LoginDetailDTO login(String uname, String password);

    boolean approveMemebr(String NIC);

    User findByID(String uname);






}
