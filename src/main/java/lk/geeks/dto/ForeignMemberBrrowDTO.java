package lk.geeks.dto;

import java.util.Date;

public class ForeignMemberBrrowDTO {


    private int brrowID;

    private Date brrowDate;

    private Date returnDate;


    private Double fee;

    private boolean isReturn;

    private ForeignMemberDTO foreignMemberDTO;

    private ItemDTO itemDTO;


    public ForeignMemberBrrowDTO(Date brrowDate, Date returnDate, Double fee, boolean isReturn, ForeignMemberDTO foreignMemberDTO, ItemDTO itemDTO) {
        this.brrowDate = brrowDate;
        this.returnDate = returnDate;
        this.fee = fee;
        this.isReturn = isReturn;
        this.foreignMemberDTO = foreignMemberDTO;
        this.itemDTO = itemDTO;
    }

    public ForeignMemberBrrowDTO() {
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

    public ForeignMemberDTO getForeignMemberDTO() {
        return foreignMemberDTO;
    }

    public void setForeignMemberDTO(ForeignMemberDTO foreignMemberDTO) {
        this.foreignMemberDTO = foreignMemberDTO;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    @Override
    public String toString() {
        return "ForeignMemberBrrowDTO{" +
                "brrowID=" + brrowID +
                ", brrowDate='" + brrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", fee=" + fee +
                ", isReturn=" + isReturn +
                ", foreignMemberDTO=" + foreignMemberDTO +
                ", itemDTO=" + itemDTO +
                '}';
    }
}
