package com.example.genievideostore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class WelcomeScreen extends Application {
    public static void setScene0(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("WelcomeScreen.fxml"));
        Scene scene0 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene0);
        stage.show();
    }
    public static void setScene1(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("LoginScreen.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene1);
        stage.show();
    }

   public static void setScene2(Stage stage) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("UserView.fxml"));
       Scene scene2 = new Scene(fxmlLoader.load(), 900, 600);
       stage.setScene(scene2);
       stage.show();

   }

    public static void setScene3(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("RentItemView.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene3);
        stage.show();
    }
    public static void setScene4(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("ReturnItemView.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene3);
        stage.show();
    }

    public static void setScene5(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("HistoryView.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene3);
        stage.show();
    }

    public static void setScene6(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("ExtendRent.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene3);
        stage.show();
    }

    public static void setScene7(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("AdminItemManagementUI.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene3);
        stage.show();
    }
    public static void setScene8(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("AdminBan.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene3);
        stage.show();
    }
    public static void setScene9(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("AdminAccountManagementUI.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene3);
        stage.show();
    }

    //My part
    public static void setScene10(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeScreen.class.getResource("AddItem.fxml"));
        Scene scene0 = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene0);
        stage.show();
    }




    @Override
    public void start(Stage stage) throws Exception {
        setScene0(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
