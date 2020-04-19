package lk.geeks.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ForeignMemberBrrow {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G1")
    @TableGenerator( name = "G1",table = "autoIncrement", allocationSize = 1,valueColumnName = "nextID")
    private int brrowID;
    @Temporal(TemporalType.DATE)
    private Date brrowDate;
    @Temporal(TemporalType.DATE)
    private Date returnDate;


    private Double fee;

    private boolean isReturn;

    @OneToOne
    @JoinColumn(name = "NIC",referencedColumnName = "NIC")
    private ForeignMember foreignMember;

    @OneToOne
    @JoinColumn(name = "itemCode", referencedColumnName = "itemCode")
    private  Item item;


    public ForeignMemberBrrow(Date brrowDate, Date returnDate, Double fee, boolean isReturn, ForeignMember foreignMember, Item item) {
        this.brrowDate = brrowDate;
        this.returnDate = returnDate;
        this.fee = fee;
        this.isReturn = isReturn;
        this.foreignMember = foreignMember;
        this.item = item;
    }

    public ForeignMemberBrrow() {
    }

    public int getBrrowID() {
        return brrowID;
    }

    public void setBrrowID(int brrowID) {
        this.brrowID = brrowID;
    }

    public Date getBrrowDate() {
        return brrowDate;
    }

    public void setBrrowDate(Date brrowDate) {
        this.brrowDate = brrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    public ForeignMember getForeignMember() {
        return foreignMember;
    }

    public void setForeignMember(ForeignMember foreignMember) {
        this.foreignMember = foreignMember;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ForeignMemberBrrowDTO{" +
                "brrowID=" + brrowID +
                ", brrowDate='" + brrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", fee=" + fee +
                ", isReturn=" + isReturn +
                ", foreignMember=" + foreignMember +
                ", item=" + item +
                '}';
    }
}
