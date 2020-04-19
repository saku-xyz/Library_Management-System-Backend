package lk.geeks.dto;

public class LoginDetailDTO {

    private String NIC;

    private String fullname;

    private String role;

    public LoginDetailDTO(String NIC, String fullname, String role) {
        this.setNIC(NIC);
        this.setFullname(fullname);
        this.setRole(role);
    }

    public LoginDetailDTO() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginDetailDTO{" +
                "NIC='" + NIC + '\'' +
                ", fullname='" + fullname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
