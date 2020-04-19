package lk.geeks.dto;

import java.util.Date;

public class LocalBookBrrowDTO {


    private int brrowID;

    private Date brrowDate;

    private Date retrunDate;

    private boolean isReturn;

    private LocalMemberDTO localMemberDTO;


    private ItemDTO itemDTO;


    public LocalBookBrrowDTO(int brrowID, Date brrowDate, Date retrunDate, boolean isReturn, LocalMemberDTO localMemberDTO, ItemDTO itemDTO) {
        this.brrowID = brrowID;
        this.brrowDate = brrowDate;
        this.retrunDate = retrunDate;
        this.isReturn = isReturn;
        this.localMemberDTO = localMemberDTO;
        this.itemDTO = itemDTO;
    }

    public LocalBookBrrowDTO(Date brrowDate, Date retrunDate, boolean isReturn, LocalMemberDTO localMemberDTO, ItemDTO itemDTO) {
        this.brrowDate = brrowDate;
        this.retrunDate = retrunDate;
        this.isReturn = isReturn;
        this.localMemberDTO = localMemberDTO;
        this.itemDTO = itemDTO;
    }

    public LocalBookBrrowDTO() {
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

    public LocalMemberDTO getLocalMemberDTO() {
        return localMemberDTO;
    }

    public void setLocalMemberDTO(LocalMemberDTO localMemberDTO) {
        this.localMemberDTO = localMemberDTO;
    }



    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }


    @Override
    public String toString() {
        return "LocalBookBrrowDTO{" +
                "brrowID=" + brrowID +
                ", brrowDate='" + brrowDate + '\'' +
                ", retrunDate='" + retrunDate + '\'' +
                ", isReturn=" + isReturn +
                ", localMemberDTO=" + localMemberDTO +
                ", itemDTO=" + itemDTO +
                '}';
    }
}
