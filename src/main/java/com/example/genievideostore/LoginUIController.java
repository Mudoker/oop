package com.example.genievideostore;

import code.VideoStore;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.ConfirmationMessage;
import utilities.ErrorHandle;
import utilities.Login;
import utilities.SuccessMessage;

import java.io.IOException;

public class LoginUIController {
    public Pane loaderPane;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField usernameLogin;
    @FXML
    private TextField pwdLogin;
    @FXML
    private Pane signinPane;
    @FXML
    private Pane signupPane;

    @FXML
    // Handle Submit Form Action
    protected void onSubmitButtonClicked () {

        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task <Void> loginTask = new Task <>() {
            @Override
            protected Void call () throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String username = usernameField.getText();
                String pwd = passwordField.getText();

                // Validate input data
                if (ErrorHandle.inputValidate(name, address, phone, username, pwd)) {
                    VideoStore.addCustomer(name, address, phone, username, pwd);
                    SuccessMessage.accept001();
                    signupPane.setVisible(false);
                    signinPane.setVisible(true);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onToSignUpButton () {
        signupPane.setVisible(true);
        signinPane.setVisible(false);
    }

    @FXML
    protected void onToSignInButton () {
        signupPane.setVisible(false);
        signinPane.setVisible(true);
    }

    @FXML
    // Users click on Turn Off icon
    protected void onTurnOffButton () {
        if (ConfirmationMessage.confirm004()) {
            Platform.exit();
        }
    }

    @FXML
    // Users have entered the credentials and hit Sign-in button
    protected void onLogInButton () throws IOException {

        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task <Void> loginTask = new Task <>() {
            @Override
            protected Void call () throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                String username = usernameLogin.getText();
                String pwd = pwdLogin.getText();
                if (username.equals("admin") || (pwd.equals("123"))) {
                    WelcomeScreen.setScene7((Stage) usernameLogin.getScene().getWindow());
                }
                else if (Login.LoginValidation(username, pwd)) {
                    WelcomeScreen.setScene2((Stage) usernameLogin.getScene().getWindow());
                }
                ;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }
}
