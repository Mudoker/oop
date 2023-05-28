package utilities;

import code.Item;

import java.util.Comparator;

public class SortItemByTitle implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getTitle().compareTo(item2.getTitle()) > 0) {
            return 1;
        }

        return -1;
    }
}
