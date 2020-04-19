package lk.geeks.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


public class ForeignMemberDTO {


    private
    String NIC;
    private String fullname;
    private String gender;
    private String email;
    private String dob;
    private String telphone;
    private String country;
    private String address;
    private boolean isApprove;
    private String userName;
    private String password;

    private ForeignMemberBrrowDTO foreignMemberBrrowDTO;

    public ForeignMemberDTO(String NIC, String fullname, String gender, String email, String dob, String telphone, String country, String address, boolean isApprove, String userName, String password) {
        this.NIC = NIC;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.telphone = telphone;
        this.country = country;
        this.address = address;
        this.isApprove = isApprove;
        this.userName = userName;
        this.password = password;
    }

    public ForeignMemberDTO(String NIC, String fullname, String gender, String email, String dob, String telphone, String country, String address, boolean isApprove) {
        this.NIC = NIC;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.telphone = telphone;
        this.country = country;
        this.address = address;
        this.isApprove = isApprove;
    }

    public ForeignMemberDTO() {
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isApprove() {
        return isApprove;
    }

    public void setApprove(boolean approve) {
        isApprove = approve;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ForeignMemberBrrowDTO getForeignMemberBrrowDTO() {
        return foreignMemberBrrowDTO;
    }

    public void setForeignMemberBrrowDTO(ForeignMemberBrrowDTO foreignMemberBrrowDTO) {
        this.foreignMemberBrrowDTO = foreignMemberBrrowDTO;
    }

    @Override
    public String toString() {
        return "ForeignMemberDTO{" +
                "NIC='" + NIC + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", telphone='" + telphone + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", isApprove=" + isApprove +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", foreignMemberBrrowDTO=" + foreignMemberBrrowDTO +
                '}';
    }
}
