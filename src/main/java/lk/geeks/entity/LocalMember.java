package lk.geeks.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class LocalMember {

    @Id
    @Size(min = 10, message = "NIC should have at least 10 characters")
    private
    String NIC;

    private String fullname;
    @Size(min = 10, message = "Telephone Number should have at least 10 characters")
    private String telephone;
    private String gender;
    private String dob;
    private String email;
    private String address;

    @OneToOne(mappedBy = "localMember",cascade = {CascadeType.ALL})
    private LocalBookBrrow localBookBrrow;

    public LocalMember(String NIC, String fullname, String telephone, String gender, String dob, String email, String address) {
        this.NIC = NIC;
        this.fullname = fullname;
        this.telephone = telephone;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.address = address;
    }

    public LocalMember() {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalBookBrrow getLocalBookBrrow() {
        return localBookBrrow;
    }

    public void setLocalBookBrrow(LocalBookBrrow localBookBrrow) {
        this.localBookBrrow = localBookBrrow;
    }

    @Override
    public String toString() {
        return "LocalMember{" +
                "NIC='" + NIC + '\'' +
                ", fullname='" + fullname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", localBookBrrow=" + localBookBrrow +
                '}';
    }
}
