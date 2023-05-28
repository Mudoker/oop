package code;

public class Rent {
    private Item rentItem;
    private long dateStart;
    private long dateEnd;
    private boolean returnStatus;
    private long actualReturnDate;

    public Rent(Item rentItem, long dateStart, long dateEnd, boolean returnStatus, long actualReturnDate) {
        this.rentItem = rentItem;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.returnStatus = returnStatus;
        this.actualReturnDate = actualReturnDate;
    }

    public Item getRentItem() {
        return rentItem;
    }

    public void setRentItem(Item rentItem) {
        this.rentItem = rentItem;
    }

    public long getDateStart() {
        return dateStart;
    }

    public void setDateStart(long dateStart) {
        this.dateStart = dateStart;
    }

    public long getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(long dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public long getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(long actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
}
