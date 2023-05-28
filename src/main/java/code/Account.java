package code;

import utilities.AlertMessage;
import utilities.IDGenerator;
import utilities.SuccessMessage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class Account {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList <Rent> rentalList;
    private String username;
    private String password;
    private boolean banStatus;

    // Constructors
    public Account (String id, String name, String address, String phoneNumber, ArrayList <Rent> rentalList, String username, String password, boolean banStatus) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rentalList = rentalList;
        this.username = username;
        this.password = password;
        this.banStatus = banStatus;
    }

    public Account () {
        this.id = "";
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        this.rentalList = new ArrayList <Rent>();
        this.username = "";
        this.password = "";
    }


    public Account (String name, String address, String phoneNumber, String username, String password) {
        this.id = IDGenerator.getCustomerID();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.rentalList = new ArrayList <Rent>();
    }



    // Getter and setter
    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList <Rent> getRentalList () {
        return rentalList;
    }

    public ArrayList <Rent> getCurrentRentalList () {
        ArrayList <Rent> rentList = new ArrayList <Rent>();
        for (Rent rent : this.getRentalList()) {
            if (! rent.isReturnStatus())
                rentList.add(rent);
        }
        return rentList;
    }

    public ArrayList <Rent> getSuccessfulRentalList () {
        ArrayList <Rent> rentList = new ArrayList <Rent>();
        for (Rent rent : this.getRentalList()) {
            if (rent.isReturnStatus())
                rentList.add(rent);
        }
        return rentList;
    }

    public void setRentalList (ArrayList <Rent> rentalList) {
        this.rentalList = rentalList;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }


    public void setPassword (String password) {
        this.password = password;
    }

    public boolean isBanStatus () {
        return banStatus;
    }

    public void setBanStatus (boolean banStatus) {
        this.banStatus = banStatus;
    }

    // Abstract function to display Account's info (implemented in subclass)
    public abstract void display ();

    // Function for users to rent an item
    public void rentItem (HashMap <Item, Integer> rentList) {
        if (isBanStatus()) {
            AlertMessage.error012();
            return;
        }
        // update item's stock
        for (Item item : rentList.keySet()) {
            for (int i = 0; i < rentList.get(item); i++) {
                long start = System.currentTimeMillis();
                long end = start + (item.getLoanType().equals("2-day") ? Duration.ofDays(2).toMillis() : Duration.ofDays(7).toMillis());
                this.getRentalList().add(new Rent(item, start, end, false, (long) 0));
            }
            item.setNumberOfCopies(item.getNumberOfCopies() - rentList.get(item));
            if (item.getNumberOfCopies() == 0) {
                item.setRentalStatus(false);
            }
        }
        // Show accept message
        SuccessMessage.accept002();

    }


    public void returnItem (ArrayList <Rent> returnList) {
        for (Rent rental : returnList) {
            rental.setReturnStatus(true);
            rental.setActualReturnDate(System.currentTimeMillis());

            if (rental.getActualReturnDate() > rental.getDateEnd()) {
                this.setBanStatus(true);
            }

            Item item = VideoStore.findItem(rental.getRentItem().getId());

            item.setNumberOfCopies(item.getNumberOfCopies() + 1);

            if (item.getNumberOfCopies() > 0) {
                item.setRentalStatus(true);
            }
        }
    }

    public String getAccountType(){
        if (this instanceof GuestAccount)
            return "Guest Account";
        if (this instanceof VIPAccount)
            return "Vip Account";
        return "Regular Account";
    }
    public int getSuccessfulRental () {
        int count = 0;
        for (Rent rental : rentalList) {
            if (rental.isReturnStatus()) {
                count++;
            }
        }
        return count;
    }

    public ArrayList <Rent> getPendingRental () {
        ArrayList <Rent> tmp = new ArrayList <Rent>();
        for (Rent i : this.rentalList) {
            if (! i.isReturnStatus()) {
                tmp.add(i);
            }
        }
        return tmp;
    }

}