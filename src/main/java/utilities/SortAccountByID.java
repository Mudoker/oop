package utilities;

import code.Account;

import java.util.Comparator;

public class SortAccountByID implements Comparator <Account> {
    @Override
    public int compare(Account acc1, Account acc2) {
        int id1 = Integer.parseInt(acc1.getId().substring(1));
        int id2 = Integer.parseInt(acc2.getId().substring(1));
        if (id1 > id2) {
            return 1;
        }
        return -1;
    }
}
