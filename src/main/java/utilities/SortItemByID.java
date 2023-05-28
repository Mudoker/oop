package utilities;

import code.Item;

import java.util.Comparator;


public class SortItemByID implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        int id1 = Integer.parseInt(item1.getId().substring(1,4));
        int id2 = Integer.parseInt(item2.getId().substring(1,4));
        if (id1 > id2) {
            return 1;
        }

        return -1;
    }
}

