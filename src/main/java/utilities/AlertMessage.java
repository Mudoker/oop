package utilities;

import javafx.scene.control.Alert;

public class AlertMessage {
    public static void error001 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Your input data must be in range of 3 - 200 characters");
        validationAlert.showAndWait();
    }

    public static void error002 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Invalid password. Please check again!");
        validationAlert.showAndWait();
    }

    public static void error003 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "No username found! Please sign-up a new account!");
        validationAlert.showAndWait();
    }

    public static void error004 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Phone Number should only contain numbers!");
        validationAlert.showAndWait();
    }

    public static void error005 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Name must contain alphabetical characters only!");
        validationAlert.showAndWait();
    }

    public static void error006 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Please do not enter special characters (eg: / @)");
        validationAlert.showAndWait();
    }

    public static void error007 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Guest Account cannot have 2 rental items at a time. Please return 2 items to be promoted!");
        validationAlert.showAndWait();
    }

    public static void error008 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Guest Account cannot rent 2-day loan. Please choose 1-week loan only!");
        validationAlert.showAndWait();
    }

    public static void error009 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "You have not selected any item! Please choose the item in the list below!");
        validationAlert.showAndWait();
    }

    public static void error010 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "This function is only for VIP accounts. Please rent and return more to join this!");
        validationAlert.showAndWait();
    }

    public static void error011 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Your VIP Point is not enough!");
        validationAlert.showAndWait();
    }

    public static void error012 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Your account has been banned! Please contact us for more information.");
        validationAlert.showAndWait();
    }

    public static void error013 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Only VIP account can access this!");
        validationAlert.showAndWait();
    }
    public static void error014 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Username taken!");
        validationAlert.showAndWait();
    }
    public static void error015 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Unmatched current password");
        validationAlert.showAndWait();
    }

    public static void error016 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Unmatched confirm password");
        validationAlert.showAndWait();
    }

    public static void error017 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Fee or stock in wrong format, please try again!");
        validationAlert.showAndWait();
    }
    public static void error018 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Phone number must be in range of 9-11 numbers!");
        validationAlert.showAndWait();
    }
    public static void error019 () {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Password must have at least 8 characters!");
        validationAlert.showAndWait();
    }
}
