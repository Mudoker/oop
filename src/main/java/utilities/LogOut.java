package utilities;

import code.VideoStore;
import com.example.genievideostore.WelcomeScreen;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LogOut {
    public static boolean LogOutAccount() {
        if (ConfirmationMessage.confirm001()) {
            VideoStore.setCurrentAccount(null);
            Database.saveAccountData();
            Database.saveItemData();
            return true;
        }
        return false;
    }
}
