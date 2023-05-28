package code;

import utilities.AlertMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class VIPAccount extends Account {
    private int vipPoint;
    private static int rewardPoint = 10;

    public VIPAccount (String id, String name, String address, String phoneNumber, ArrayList <Rent> rentalList, String username, String password, boolean banStatus, int VIPPoint) {
        super(id, name, address, phoneNumber, rentalList, username, password, banStatus);
        this.vipPoint = VIPPoint;
    }

//    public VIPAccount() {
//        super();
//        this.vipPoint = 0;
//    }

//    public VIPAccount(String id ,String name, String address, String phoneNumber, String username, String password) {
//        super(id, name, address, phoneNumber, username, password);
//        this.vipPoint = vipPoint;
//    }

    public int getVipPoint () {
        return vipPoint;
    }

    public void setVipPoint (int vipPoint) {
        this.vipPoint = vipPoint;
    }

    public void display () {
        System.out.println("VIP Account{" +
                "id ='" + super.getId() + '\'' +
                ", name ='" + super.getName() + '\'' +
                ", address ='" + super.getAddress() + '\'' +
                ", phoneNumber ='" + super.getPhoneNumber() + '\'' +
                ", Account ='" + " VIP" + '\'' +
                ", number of rentals =" + super.getRentalList().size() +
                ", username ='" + super.getUsername() + '\'' +
                ", Total rental ='" + super.getRentalList().size() + '\'' +
                ", Returned rental ='" + super.getSuccessfulRental() + '\'' +
                ", Current rental ='" + super.getPendingRental().size() + '\'' +
                ", Vip Point ='" + this.vipPoint + '\'' +
                '}');
    }

    public void rentItem (HashMap <Item, Integer> rentList) {
        for (Item item : rentList.keySet()) {
            this.vipPoint += rentList.get(item) * rewardPoint;
        }
        super.rentItem(rentList);
    }

    public void rentFreeItem (HashMap <Item, Integer> rentList) {
        for (Item item : rentList.keySet()) {
            this.vipPoint -= rentList.get(item) * 100;
        }
        super.rentItem(rentList);
    }

    public void extendRentDate (HashMap <Rent, Integer> rentList) {
        int total = 0;
        for (Rent i : rentList.keySet()) {
            total += 50 * rentList.get(i);
        }
        if (this.vipPoint - total >= 0) {
            for (Rent item : rentList.keySet()) {
                if (! item.isReturnStatus()) {
                    item.setDateEnd(item.getDateEnd() + 86400000 * rentList.get(item));
                }
            }
            this.setVipPoint(this.vipPoint - total);
            return;
        }
        AlertMessage.error011();
    }
}
