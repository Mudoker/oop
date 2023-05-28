package utilities;

import code.VideoStore;

public class IDGenerator {
    private static int customerID = 0;
    private static int itemID = 0;

    public IDGenerator(){
    }

    public static String getCustomerID() {

        customerID = VideoStore.getAccountList().size() + 1;
        if (customerID > 999)
            return null;
        return String.format("C%03d", customerID);
    }
    public static String getItemID(int year) {
        itemID = VideoStore.getItemList().size() + 1;
        if (itemID > 999)
            return null;
        return String.format("I%03d-%d", itemID, year);
    }

}
