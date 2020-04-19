package lk.geeks.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


public class UserDTO {


    private
    String uname;

    private String password;

    private boolean isApprove;

    private String memberType;

    private String nic;


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(boolean isApprove) {
        this.isApprove = isApprove;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public UserDTO(String uname, String password, boolean isApprove, String memberType, String nic) {
        this.uname = uname;
        this.password = password;
        this.isApprove = isApprove;
        this.memberType = memberType;
        this.nic = nic;
    }

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", isApprove='" + isApprove + '\'' +
                ", memberType='" + memberType + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
