package lk.geeks.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
public class LocalBookBrrow {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G1")
    @TableGenerator(name = "G1", table = "autoIncrement", allocationSize = 1,valueColumnName = "nextID")
    private int brrowID;

    @Temporal(TemporalType.DATE)
    private Date brrowDate;
    @Temporal(TemporalType.DATE)
    private Date retrunDate;

    private boolean isReturn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIC",referencedColumnName = "NIC")
    private LocalMember localMember;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemCode",referencedColumnName = "itemCode")
    private Item item;


    public LocalBookBrrow(Date brrowDate, Date retrunDate, boolean isReturn, LocalMember localMember, Item item) {
        this.brrowDate = brrowDate;
        this.retrunDate = retrunDate;
        this.isReturn = isReturn;
        this.localMember = localMember;
        this.item = item;
    }

    public LocalBookBrrow() {
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

    public Date getRetrunDate() {
        return retrunDate;
    }

    public void setRetrunDate(Date retrunDate) {
        this.retrunDate = retrunDate;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    public LocalMember getLocalMember() {
        return localMember;
    }

    public void setLocalMember(LocalMember localMember) {
        this.localMember = localMember;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "LocalBookBrrowDTO{" +
                "brrowID=" + brrowID +
                ", brrowDate='" + brrowDate + '\'' +
                ", retrunDate='" + retrunDate + '\'' +
                ", localMember=" + localMember +
                ", item=" + item +
                '}';
    }
}
