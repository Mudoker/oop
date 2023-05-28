package utilities;

import code.Account;
import code.Item;
import code.Rent;
import code.VideoStore;

import java.util.ArrayList;

public class SearchEngine {
    public static Item searchItem(String searchBar){
        for (Item item: VideoStore.getItemList()) {
            if ((item.getTitle().equals(searchBar)) || (item.getId().equals(searchBar))) {
                return item;
            }
        }

        return null;
    }

    public static Account searchCustomer(String searchBar){
        for (Account account: VideoStore.getAccountList()) {
            if ((account.getId().equals(searchBar)) || (account.getName().equals(searchBar)) || (account.getAddress().equals(searchBar))) {
                return account;
            }
        }

        System.out.println("Customer not found!");
        return null;
    }

    public static Account searchCustomerThroughPwd(String pwd){
        for (Account account: VideoStore.getAccountList()) {
            if ((account.getPassword().equals(pwd))) {
                return account;
            }
        }

        System.out.println("Customer not found!");
        return null;
    }

//    public static Account searchCustomerThroughAddress(String address){
//        for (Account account: VideoStore.getAccountList()) {
//            if ((account.getAddress().equals(address))) {
//                return account;
//            }
//        }
//
//        System.out.println("Customer not found!");
//        return null;
//    }
    public static ArrayList<Rent> searchRental(String searchBar,ArrayList<Rent> searchList) {
        ArrayList<Rent> result = new ArrayList<Rent>();
        for (Rent rental : searchList) {
            if (rental.getRentItem().getId().equals(searchBar) || rental.getRentItem().getTitle().equals(searchBar)) {
                result.add(rental);
            }
        }
        return result;
    }
}
