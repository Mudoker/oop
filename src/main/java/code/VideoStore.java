package code;

import utilities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class VideoStore {
	private static ArrayList <Item> itemList = Database.loadItemData();
	private static ArrayList <Account> accountList = Database.loadAccountData();
	private static Account currentAccount = null;

	public VideoStore (ArrayList <Item> itemList, ArrayList <Account> accountList) {
		this.itemList = itemList;
		this.accountList = accountList;
	}

	public static Account getCurrentAccount () {
		return currentAccount;
	}

	public static void setCurrentAccount (Account currentAccount) {
		VideoStore.currentAccount = currentAccount;
	}

	public static ArrayList <Item> getItemList () {
		return itemList;
	}

	public void setItemList (ArrayList <Item> itemList) {
		this.itemList = itemList;
	}

	public static ArrayList <Account> getAccountList () {
		return accountList;
	}

	public void setAccountList (ArrayList <Account> accountList) {
		this.accountList = accountList;
	}


	public static void addCustomer (String name, String address, String phoneNum, String username, String password) {
		Account newAcc = new GuestAccount(name, address, phoneNum, username, password);
		accountList.add(newAcc);
		Database.saveItemData();
		Database.saveAccountData();
	}

	public static void updateCustomer (String name, String address, String phoneNum, String password) {
//        if (currentAccount != null) {
//            currentAccount.updateInfo();
//        }
	}

	public static void rentNewItem (HashMap <Item, Integer> toRentList) {
		currentAccount.rentItem(toRentList);
	}

	public static void returnItem (ArrayList <Rent> returnList) {
		currentAccount.returnItem(returnList);
		currentAccount = promoteCustomer();
	}

	public static ArrayList <Account> displayAllAccount () {
		return accountList;
	}

	public static ArrayList <Account> displayGuestAccount () {
		ArrayList <Account> GuestList = new ArrayList <Account>();
		for (Account acc : accountList) {
			if (acc instanceof GuestAccount) {
				GuestList.add(acc);
			}
		}
		return GuestList;
	}

	public static ArrayList <Account> displayRegularAccount () {
		ArrayList <Account> RegularList = new ArrayList <Account>();
		for (Account acc : accountList) {
			if (acc instanceof RegularAccount) {
				RegularList.add(acc);
			}
		}
		return RegularList;
	}

	public static ArrayList <Account> displayVIPAccount () {
		ArrayList <Account> VIPList = new ArrayList <Account>();
		for (Account acc : accountList) {
			if (acc instanceof VIPAccount) {
				VIPList.add(acc);
			}
		}
		return VIPList;
	}

	// Display all items without any sorting
	public static ArrayList <Item> displayActiveItem () {
		ArrayList <Item> stockAvailable = new ArrayList <Item>();
		for (Item item : itemList) {
			if (item.isActiveStatus())
				stockAvailable.add(item);
		}
		return stockAvailable;
	}

	//Display list of items sorted by item's ID (Complete)
	public static ArrayList <Item> displayItemSortByID (ArrayList <Item> itemListSortByID) {
		Collections.sort(itemListSortByID, new SortItemByID());
		return itemListSortByID;
	}

	//Display list of items sorted by item's title (Complete)
	public static ArrayList <Item> displayItemSortByTitle (ArrayList <Item> itemListSortByName) {
		Collections.sort(itemListSortByName, new SortItemByTitle());
		return itemListSortByName;
	}

	public static ArrayList <Item> displayDVDItem () {
		ArrayList <Item> DVDList = new ArrayList <Item>();
		for (Item item : displayActiveItem()) {
			if (item instanceof DVD) {
				DVDList.add(item);
			}
		}
		return DVDList;
	}

	public static ArrayList <Item> displayVideoGameItem () {
		ArrayList <Item> videoGameList = new ArrayList <Item>();
		for (Item item : displayActiveItem()) {
			if (item instanceof VideoGame) {
				videoGameList.add(item);
			}
		}
		return videoGameList;
	}

	public static ArrayList <Item> displayRecordItem () {
		ArrayList <Item> oldRecordList = new ArrayList <Item>();
		for (Item item : displayActiveItem()) {
			if (item instanceof OldMovieRecord) {
				oldRecordList.add(item);
			}
		}
		return oldRecordList;
	}

	public static ArrayList <Item> displayItemWithStock () {
		ArrayList <Item> stockAvailable = new ArrayList <Item>();
		for (Item item : itemList) {
			if (item.isRentalStatus())
				stockAvailable.add(item);
		}
		return stockAvailable;
	}

    public static void findCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search with ID or title:");
        String searchBar = sc.nextLine();
        Account tempAccount = SearchEngine.searchCustomer(searchBar);

        if (tempAccount == null){
            System.out.println("Error 6");
        }
        else
            tempAccount.display();
    }

	public static ArrayList <Item> displayItemWithNoStock () {
		ArrayList <Item> stockAvailable = new ArrayList <Item>();
		for (Item item : itemList) {
			if (! item.isRentalStatus())
				stockAvailable.add(item);
		}
		return stockAvailable;
	}

	public static ArrayList <Rent> displayRentalItem () {
		return currentAccount.getCurrentRentalList();
	}

	//Display list of accounts sorted by account's ID (Complete)
	public static ArrayList <Account> displayAccountSortByID (ArrayList <Account> accountDisplayList) {
		Collections.sort(accountDisplayList, new SortAccountByID());
		return accountDisplayList;

	}

	//Display list of accounts sorted by account's name (Complete)
	public static ArrayList <Account> displayAccountSortByName (ArrayList <Account> accountDisplayList) {
		Collections.sort(accountDisplayList, new SortAccountByName());
		return accountDisplayList;
	}

	public static Item findItem (String keyword) {
		Item tempItem = SearchEngine.searchItem(keyword);

		if (tempItem == null) {
			return null;
		}
		return tempItem;
	}

    public static void rentFreeVIP(HashMap<Item,Integer> rentList) {
        if (currentAccount instanceof VIPAccount) {
            ((VIPAccount)currentAccount).rentFreeItem(rentList);
        }
    }

	public static ArrayList <Rent> findRent (String keyword) {
		return SearchEngine.searchRental(keyword, currentAccount.getRentalList());
	}

	public static Account findCustomer (String keyword) {
		Account tempAccount = SearchEngine.searchCustomer(keyword);

		if (tempAccount == null) {
			System.out.println("Error 6");
			return null;
		} else {
			return tempAccount;
		}
	}

	public static Account promoteCustomer () {

		if (currentAccount.getSuccessfulRentalList().size() > 3 && currentAccount instanceof GuestAccount) {
			// Get the relevant data from the guestAccount and replace a Guest by a new RegularAccount
			String id = currentAccount.getId();
			String name = currentAccount.getName();
			String address = currentAccount.getAddress();
			String phoneNum = currentAccount.getPhoneNumber();
			String username = currentAccount.getUsername();
			String password = currentAccount.getPassword();
			boolean banStatus = currentAccount.isBanStatus();
			Account regularAccount = new RegularAccount(id, name, address, phoneNum, currentAccount.getRentalList(), username, password, banStatus);
			accountList.remove(currentAccount);
			accountList.add(regularAccount);

			SuccessMessage.accept004();
			return regularAccount;
		}

		if (currentAccount.getSuccessfulRentalList().size() > 5 && currentAccount instanceof RegularAccount) {
			// Get the relevant data from the guestAccount and replace the regular with a VIP account
			String id = currentAccount.getId();
			String name = currentAccount.getName();
			String address = currentAccount.getAddress();
			String phoneNum = currentAccount.getPhoneNumber();
			String username = currentAccount.getUsername();
			String password = currentAccount.getPassword();
			boolean banStatus = currentAccount.isBanStatus();
			int vipPoint = currentAccount.getRentalList().size() * 10;
			Account vipAccount = new VIPAccount(id, name, address, phoneNum, currentAccount.getRentalList(), username, password, banStatus, vipPoint);
			accountList.remove(currentAccount);
			accountList.add(vipAccount);

			SuccessMessage.accept005();
			return vipAccount;
		}
		return currentAccount;
	}


	public static void displayBanAccount () {
		for (Account i : accountList) {
			if (i.isBanStatus()) {
				i.display();
			}
		}
	}

	public static void revolveBanStatus (ArrayList <Account> accountList) {
		for (Account i : accountList) {
			if (i.isBanStatus()) {
				i.setBanStatus(false);
			}
		}
	}
	public static void deleteItem(Item item){
		if (ConfirmationMessage.confirm008() == true);
		item.setActiveStatus(false);
	}

	public static void addItem(Item item){
		itemList.add(item);
		Database.saveItemData();
	}
}

