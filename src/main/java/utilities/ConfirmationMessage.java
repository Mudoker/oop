package utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ConfirmationMessage {
    public static boolean confirm001() {
        Alert validationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure that you want to log out ?");
        ButtonType result = validationAlert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK)
            return true;
        else
            validationAlert.close();
        return false;
    }

    public static boolean confirm002() {
        Alert validationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure that you want to rent this/these item(s) ?");
        ButtonType result = validationAlert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK)
            return true;
        else
            validationAlert.close();
        return false;
    }
    public static boolean confirm003() {
        Alert validationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure that you want to return this/these item(s) ?");
        ButtonType result = validationAlert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK)
            return true;
        else
            validationAlert.close();
        return false;
    }
    public static boolean confirm004() {
        Alert validationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure that you want to quit the application ?");
        ButtonType result = validationAlert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK)
            return true;
        else
            validationAlert.close();
        return false;
    }
    public static boolean confirm005 () {
        Alert validationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure that you want to extend these items ?");
        ButtonType result = validationAlert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK)
            return true;
        else
            validationAlert.close();
        return false;
    }

    public static boolean confirm006 () {
        Alert validationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure that you want to resolve ban for these customers ?");
        ButtonType result = validationAlert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK)
            return true;
        else
            validationAlert.close();
        return false;
    }

    public static boolean confirm007(){
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to add this item?");
        ButtonType result = confirmDelete.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK)
            return true;
        else
            confirmDelete.close();
        return false;
    }
    public static boolean confirm008(){
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete this item?");
        ButtonType result = confirmDelete.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK)
            return true;
        else
            confirmDelete.close();
        return false;
    }
}