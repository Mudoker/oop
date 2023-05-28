package utilities;

import code.Account;

import java.util.Comparator;

public class SortAccountByName implements Comparator <Account> {
    @Override
    public int compare(Account acc1, Account acc2) {
        if (acc1.getName().compareTo(acc2.getName()) > 0) {
            return 1;
        }

        return -1;
    }
}
