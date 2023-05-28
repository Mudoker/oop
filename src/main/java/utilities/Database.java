package utilities;

import code.*;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class Database {
    // Load Account Database (Complete)
    public static ArrayList <Account> loadAccountData () {
        ArrayList <Account> accountList = new ArrayList <Account>();
        File dir = new File("database/customer.txt");
        BufferedReader inputStream = null;
        String line;

        // Correct file path to Account database
        try {
            inputStream = new BufferedReader(new FileReader(dir));
            while ((line = inputStream.readLine()) != null) {
                ArrayList<Rent> rentalList = new ArrayList<Rent>();
                String[] tokens = line.split(",");
                int vipPoint = -1;

                // Extract data from each record(line)
                String customerID = tokens[0];
                String name = tokens[1];
                String address = tokens[2];
                String phoneNumber = tokens[3];
                int rentalQuantity = Integer.parseInt(tokens[4]);
                String accountType = tokens[5];
                String username = tokens[6].strip();
                String pwd = tokens[7].strip();

                boolean banStatus = Boolean.valueOf(tokens[8]);
                if (accountType.equals("VIP")) {
                    vipPoint = Integer.parseInt(tokens[9]);
                }

                if (rentalQuantity > 0) {
                    for (int i = 0; i < rentalQuantity; i++) {
                        String tmp = inputStream.readLine();
                        tokens = tmp.split(",");
                        Item itemFind = SearchEngine.searchItem(tokens[0]);

                        if (itemFind != null) {
                            long dateStart = Long.valueOf(tokens[1]);
                            long dateEnd = Long.valueOf(tokens[2]);
                            boolean returnStatus = Boolean.valueOf(tokens[3]);
                            long realReturnDate = Long.valueOf(tokens[4]);
                            if (realReturnDate > dateEnd) {
                                banStatus = true;
                            }
                            else if (System.currentTimeMillis() > dateEnd && realReturnDate == 0) {
                                banStatus = true;
                            }
                            Rent newRent = new Rent(itemFind,dateStart,dateEnd,returnStatus,realReturnDate);
                            rentalList.add(newRent);
                        }
                    }
                }

                if (accountType.equals("VIP")) {
                    Account newAcc = new VIPAccount(customerID, name, address, phoneNumber, rentalList, username, pwd, banStatus,vipPoint);
                    accountList.add(newAcc);
                } else if (accountType.equals("Regular")) {
                    Account newAcc = new RegularAccount(customerID, name, address, phoneNumber, rentalList, username, pwd, banStatus);
                    accountList.add(newAcc);
                } else {
                    Account newAcc = new GuestAccount(customerID, name, address, phoneNumber, rentalList, username, pwd, banStatus);
                    accountList.add(newAcc);
                }
            }
            // Incorrect file path
        } catch (IOException e) {
            System.out.println("Fail to open file!");
        }
        // Load Account data
        return accountList;
    }

    // Load Item Database (Complete)
    public static ArrayList <Item> loadItemData () {
        ArrayList <Item> itemList = new ArrayList <Item>();
        File dir = new File("database/item.txt");
        BufferedReader inputStream = null;
        String line;

        //Correct file path to Account database
        try {
            inputStream = new BufferedReader(new FileReader(dir));
            while ((line = inputStream.readLine()) != null) {
                String[] tokens = line.split(",");

                // Extract data from each record(line)
                String itemID = tokens[0];
                String name = tokens[1];
                String itemType = tokens[2];
                String loanType = tokens[3];
                int stock = Integer.parseInt(tokens[4]);
                double rentalPrice = Double.parseDouble(tokens[5]);
                boolean activeStatus = Boolean.valueOf(tokens[6]);

                if (itemType.equals("Game")) {
                    Item newItem = new VideoGame(itemID, name, itemType, loanType, stock, rentalPrice, activeStatus);
                    itemList.add(newItem);
                } else if (itemType.equals("Record")) {
                    String genre = tokens[7];
                    Item newItem = new OldMovieRecord(itemID, name, itemType, loanType, stock, rentalPrice, activeStatus, genre);
                    itemList.add(newItem);
                } else {
                    String genre = tokens[7];
                    Item newItem = new DVD(itemID, name, itemType, loanType, stock, rentalPrice,activeStatus,genre);
                    itemList.add(newItem);
                }
            }
            inputStream.close();

            // Error file path
        } catch (IOException e) {
            System.out.println("Fail to open file!");
        }

        // Load Item data
        return itemList;
    }

    // Save Account to database (Complete)
    public static void saveAccountData () {
        File dir = new File("database/customer.txt");
        BufferedWriter outputStream = null;
        try {
            outputStream = new BufferedWriter(new FileWriter(dir));
            // Object casting to save different kind of items to database file
            Collections.sort(VideoStore.getAccountList(), new SortAccountByID());
            for (Account account : VideoStore.getAccountList()) {
                String accountType;

                if (account instanceof GuestAccount) {
                    accountType = "Guest";
                    outputStream.write(account.getId() + ',' + account.getName() + ',' +
                            account.getAddress() + ',' + account.getPhoneNumber() + ',' + account.getRentalList().size()
                            + ',' + accountType + ", " + account.getUsername() + ", " + account.getPassword()
                            + ',' + String.valueOf(account.isBanStatus()) + '\n');
                }
                else if (account instanceof RegularAccount) {
                    accountType = "Regular";
                    outputStream.write(account.getId() + ',' + account.getName() + ',' +
                            account.getAddress() + ',' + account.getPhoneNumber() + ',' + account.getRentalList().size()
                            + ',' + accountType + ", " + account.getUsername() + ", " + account.getPassword()
                            + ',' + account.isBanStatus() + '\n');
                }
                else {
                    accountType = "VIP";
                    outputStream.write(account.getId() + ',' + account.getName() + ',' +
                            account.getAddress() + ',' + account.getPhoneNumber() + ',' + account.getRentalList().size()
                            + ',' + accountType + ", " + account.getUsername() + ", " + account.getPassword()
                            + ',' + account.isBanStatus() + ',' + ((VIPAccount) account).getVipPoint() + '\n');
                }

                for (Rent rental:account.getRentalList()) {
                    outputStream.write(rental.getRentItem().getId() + ',' + rental.getDateStart() + ',' +
                            rental.getDateEnd() + ',' + rental.isReturnStatus() + ',' + rental.getActualReturnDate() + '\n');

                }
            }
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Fail to create file!");
        }
    }

    // Save Item to database (Complete)
    public static void saveItemData () {
        File dir = new File("database/item.txt");
        BufferedWriter outputStream = null;
        try {
            outputStream = new BufferedWriter(new FileWriter(dir));

            Collections.sort(VideoStore.getItemList(), new SortItemByID());
            // Object casting to save different kind of items to database file
            for (Item item : VideoStore.getItemList()) {
                if (item instanceof VideoGame)
                    outputStream.write(item.getId() + ',' +
                            item.getTitle() + ',' + item.getRentalType() + ',' + item.getLoanType() + ',' +
                            item.getNumberOfCopies() + ',' + item.getRentalFee() + ',' + item.isActiveStatus() + '\n');
                else if (item instanceof DVD) {
                    outputStream.write(item.getId() + ',' +
                            item.getTitle() + ',' + item.getRentalType() + ',' + item.getLoanType() + ',' +
                            item.getNumberOfCopies() + ',' + item.getRentalFee() + ',' + item.isActiveStatus() + ',' + ((DVD) item).getGenre() + "\n");
                } else {
                    outputStream.write(item.getId() + ',' +
                            item.getTitle() + ',' + item.getRentalType() + ',' + item.getLoanType() + ',' +
                            item.getNumberOfCopies() + ',' + item.getRentalFee() + ',' + item.isActiveStatus() + ',' + ((OldMovieRecord) item).getGenre() + "\n");
                }
            }
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Fail to create file!");
        }
    }


}