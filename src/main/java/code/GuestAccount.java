package code;
import javafx.scene.control.Alert;
import utilities.AlertMessage;
import utilities.SearchEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GuestAccount extends Account{
    public GuestAccount(String id, String name, String address, String phoneNumber, ArrayList<Rent> rentalList, String username, String password, boolean banStatus) {
        super(id, name, address, phoneNumber, rentalList, username, password, banStatus);
    }

    public GuestAccount(String name, String address, String phoneNumber, String username, String password) {
        super(name, address, phoneNumber, username, password);
    }


    @Override
    public void display() {
        System.out.println("Guest Account{" +
                "id ='" + super.getId() + '\'' +
                ", name ='" + super.getName() + '\'' +
                ", address ='" + super.getAddress() + '\'' +
                ", phoneNumber ='" + super.getPhoneNumber() + '\'' +
                ", number of rentals =" + super.getRentalList().size() +
                ", username ='" + super.getUsername() + '\'' +
                '}');
    }
    public void rentItem (HashMap<Item,Integer> rentList) {
        // If the current user want to borrow the third item.
        int totalItem = 0;
        for (Item item: rentList.keySet()) {
            if (Objects.equals(item.getLoanType().toLowerCase(), "2-day".toLowerCase())) {
                AlertMessage.error008();
                return;
            }
            totalItem += rentList.get(item);
        }
        if (this.getCurrentRentalList().size() + totalItem > 2) {
            AlertMessage.error007();
            return;
        }


        super.rentItem(rentList);
    }
}


