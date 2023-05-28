package code;

public class VideoGame extends Item{
    public VideoGame(String id, String title, String rentalType, String loanType,int stock, double rentalFee, boolean activeStatus) {
        super(id, title, rentalType, loanType,stock, rentalFee, activeStatus);
    }

    public VideoGame(String title, String rentalType, String loanType,int stock, double rentalFee, int year) {
        super(title, rentalType, loanType,stock, rentalFee, year);
    }

public void display() {
    System.out.println("Item{" +
            "id='" + super.getId() + '\'' +
            ", title='" + super.getTitle() + '\'' +
            ", rentalType='" + super.getRentalType() + '\'' +
            ", loanType='" + super.getLoanType() + '\'' +
            ", rentalFee=" + super.getRentalFee() +
            ", rentalStatus=" + super.isRentalStatus() +
            ", activeStatus=" + super.isActiveStatus() +
            '}');
}


}
