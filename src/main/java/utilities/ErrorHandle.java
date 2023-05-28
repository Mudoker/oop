package utilities;

import code.Account;
import code.Item;
import code.VideoStore;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Objects;

public class ErrorHandle {
    public static int MIN_CHAR = 3;
    public static int PWD = 8;
    public static int MIN_NUM = 9;
    public static int MAX_CHAR = 201;
    public static int MAX_NUM = 11;
    public static boolean inputValidate(String name, String address, String phone, String username, String pwd) {
        if (!customerNameValidate(name) || !customerPhoneNumberValidate(phone) || !customerAddressValidate(address)
                || !customerUsernameValidate(username) || !customerPasswordValidate(pwd)) {
            return false;
        }
        return true;
    }
    public static boolean customerNameValidate(String name) {
        if ((name.length() < MIN_CHAR) || (name.length() > MAX_CHAR)) {
            AlertMessage.error001();
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isSpaceChar(name.charAt(i)))
                continue;

            if (!Character.isLetter(name.charAt(i))) {
                AlertMessage.error005();
                return false;
            }
        }
        return true;
    }
    public static boolean customerUsernameValidate(String username) {
        ArrayList<Account> accounts = VideoStore.getAccountList();
        if ((username.length() < MIN_CHAR) || (username.length() > MAX_CHAR)) {
            AlertMessage.error001();
            return false;
        }
        if (username.equals("admin")) {
            AlertMessage.error014();
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetterOrDigit(username.charAt(i))) {
                AlertMessage.error006();
                return false;
            }
        }
        for (Account i : accounts) {
            if (Objects.equals(i.getUsername(), username)) {
                AlertMessage.error014();
                return false;
            }
        }
        return true;
    }

    public static boolean customerAddressValidate(String address) {
        if ((address.length() < MIN_CHAR) || (address.length() > MAX_CHAR)) {
            AlertMessage.error001();
            return false;
        }

        for (int i = 0; i < address.length(); i++) {
            if (Character.isSpaceChar(address.charAt(i)))
                continue;

            if (!Character.isLetterOrDigit(address.charAt(i))) {
                AlertMessage.error006();
                return false;
            }
        }

        return true;
    }

    public static boolean customerPhoneNumberValidate(String phoneNumber) {
        if ((phoneNumber.length() < MIN_NUM) || (phoneNumber.length() > MAX_NUM)) {
            AlertMessage.error018();
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                AlertMessage.error004();
                return false;
            }
        }
        return true;
    }

    public static boolean customerPasswordValidate(String pwd) {
        if ((pwd.length() < PWD) || (pwd.length() > MAX_CHAR)) {
            AlertMessage.error019();
            return false;
        }

        for (int i = 0; i < pwd.length(); i++) {
            if (!Character.isLetterOrDigit(pwd.charAt(i))) {
                AlertMessage.error006();
                return false;
            }
        }
        return true;
    }

    public static boolean currPwdValidation(String currPwd){
        Account account = VideoStore.getCurrentAccount();
        if (account.getPassword().equals(currPwd)){
            return true;
        }
        else{
            AlertMessage.error015();
            return false;
        }
    }

    public static boolean changePwdValidation(String confirmPwd, String newPwd){
        if (confirmPwd.equals(newPwd)){
            return true;
        }
        else{
            AlertMessage.error016();
            return false;
        }
    }
}
