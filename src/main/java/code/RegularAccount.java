package code;
import java.util.ArrayList;
import java.util.HashMap;

public class RegularAccount extends Account{

    public RegularAccount(String id, String name, String address, String phoneNumber, ArrayList<Rent> rentalList, String username, String password, boolean banStatus) {
        super(id,name, address, phoneNumber, rentalList, username, password, banStatus);
    }


    @Override
    public void display() {
        System.out.println("Regular Account{" +
                "id ='" + super.getId() + '\'' +
                ", name ='" + super.getName() + '\'' +
                ", address ='" + super.getAddress() + '\'' +
                ", phoneNumber ='" + super.getPhoneNumber() + '\'' +
                ", number of rentals =" + super.getRentalList().size() +
                ", username ='" + super.getUsername() + '\'' +
                '}');
    }

    public void rentItem(HashMap<Item,Integer> rentList) {
        super.rentItem(rentList);
    }
}

