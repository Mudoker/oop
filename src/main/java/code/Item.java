package code;

import utilities.IDGenerator;

public abstract class Item {
    private String id;
    private String title;
    private String rentalType;
    private String loanType;
    public int numberOfCopies;
    private double rentalFee;
    private boolean rentalStatus;
    private boolean activeStatus;

    public Item(String id, String title, String rentalType, String loanType,int stock, double rentalFee, boolean activeStatus) {
        this.id = id;
        this.title = title;
        this.rentalType = rentalType;
        this.loanType = loanType;
        this.rentalFee = rentalFee;;
        this.numberOfCopies = stock;
        this.activeStatus = activeStatus;
        this.rentalStatus = (numberOfCopies > 0) ? true : false;
    }


    public Item(String title, String rentalType, String loanType,int stock, double rentalFee, int year) {
        this.id = IDGenerator.getItemID(year);
        this.title = title;
        this.rentalType = rentalType;
        this.loanType = loanType;
        this.rentalFee = rentalFee;;
        this.numberOfCopies = stock;
        this.activeStatus = true;
        this.rentalStatus = (numberOfCopies > 0) ? true : false;
    }


    public Item() {
        this.id = "";
        this.title = "";
        this.rentalType = "";
        this.loanType = "";
        this.numberOfCopies = 0;
        this.rentalFee = 0.0;
        this.rentalStatus = (numberOfCopies > 0) ? true : false;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getNumberOfCopies() {
        return this.numberOfCopies;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public boolean isRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public abstract void display();

}
