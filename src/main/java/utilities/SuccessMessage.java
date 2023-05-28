package utilities;

import javafx.scene.control.Alert;

public class SuccessMessage {
    public static void accept001() {
        Alert validationAlert = new Alert(Alert.AlertType.INFORMATION, "Congratulation! You have registered successfully. Please log in!");
        validationAlert.showAndWait();
    }
    public static void accept002() {
        Alert acceptAlert = new Alert(Alert.AlertType.INFORMATION, "Rent item successfully");
        acceptAlert.showAndWait();
    }
    public static void accept003() {
        Alert acceptAlert = new Alert(Alert.AlertType.INFORMATION, "Return item successfully!");
        acceptAlert.showAndWait();
    }
    public static void accept004() {
        Alert message = new Alert(Alert.AlertType.INFORMATION, "Congratulations! You have been promoted to Regular Account!");
        message.showAndWait();
    }
    public static void accept005() {
        Alert message = new Alert(Alert.AlertType.INFORMATION, "Congratulations! You have been promoted to VIP Account!");
        message.showAndWait();
    }

    public static void accept006() {
        Alert message = new Alert(Alert.AlertType.INFORMATION, "Resolve Ban Successfully!");
        message.showAndWait();
    }

    public static void accept007() {
        Alert message = new Alert(Alert.AlertType.INFORMATION, "Password updated!");
        message.showAndWait();
    }
    public static void accept008() {
        Alert message = new Alert(Alert.AlertType.INFORMATION, "Update Item successfully!");
        message.showAndWait();
    }

    public static void accept009(){
        Alert message = new Alert(Alert.AlertType.INFORMATION, "Add item successfully!");
        message.showAndWait();
    }
}
