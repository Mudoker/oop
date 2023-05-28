package utilities;

import code.Account;
import code.VideoStore;
import javafx.scene.control.Alert;

public class Login {
    public static boolean LoginValidation(String username, String password) {
        for (Account i : VideoStore.getAccountList()) {
            if (username.equals(i.getUsername())) {
                if (password.equals(i.getPassword())) {
                    VideoStore.setCurrentAccount(i);
                    return true;
                } else {
                    AlertMessage.error002();
                    return false;
                }
            }
        }
        AlertMessage.error003();
        return false;
    }

    public static boolean ChangePwdValidation(String currPass) {
        System.out.println(currPass);
        int count = 0;
        for (Account i : VideoStore.getAccountList()) {
            if (currPass.equals(i.getPassword())) {
                return true;
            }
        }
//        if (count == VideoStore.getAccountList().size()) {
//            AlertMessage.error002();
//            return false;
//        }
//        System.out.println(count);
        AlertMessage.error002();
        return false;
    }
}
