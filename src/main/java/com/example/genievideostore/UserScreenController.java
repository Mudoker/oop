package com.example.genievideostore;

import code.Account;
import code.VIPAccount;
import code.VideoStore;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.*;

import java.io.IOException;

public class UserScreenController {
    @FXML
    public Pane loaderPane;
    //label
    @FXML
    private Label nameDisplayLabel;

    // edit pane and display pane
    @FXML
    private Pane displayNamePane;
    @FXML
    private Pane displayAddressPane;
    @FXML
    private Pane editNamePane;
    @FXML
    private Pane editAddressPane;
    @FXML
    private Pane editPwdPane;

    // text-field edit
    @FXML
    private TextField newName;
    @FXML
    private TextField newAddress;

    //edit button in first pane
    @FXML
    private ImageView firstEditNameButton;
    @FXML
    private ImageView firstEditAddressButton;
    @FXML
    private ImageView firstEditPwdButton;

    //edit button in second pane
    @FXML
    private Button editNameButton;
    @FXML
    private Button editNewAddress;

    //cancel button
    @FXML
    private Button cancelEditAddressButton;
    @FXML
    private Button cancelEditNameButton;

    // change password
    @FXML
    protected Button change;
    @FXML
    protected Label cancel;
    @FXML
    protected TextField currPwd;

    @FXML
    protected TextField newPwd;

    @FXML
    protected TextField confirmPwd;

    // dynamic data
    @FXML
    private Label fullNameLabel;

    @FXML
    protected Label addressLabel;

    @FXML
    protected Label phoneLabel;

    @FXML
    protected Label passwordLabel;

    @FXML
    protected Label userNameLabel;
    @FXML
    protected Label vipPointLabel;

    @FXML
    protected Label accountTypeLabel;

    // Dynamic Data Initialize
    @FXML
    protected Label test;

    @FXML
    protected Pane vipAccount;

    @FXML
    protected Pane guestAccount;

    @FXML
    protected Pane regularAccount;

    @FXML
    public void initialize() {
        nameDisplayLabel.setText(VideoStore.getCurrentAccount().getName());
        fullNameLabel.setText(VideoStore.getCurrentAccount().getName());
        addressLabel.setText(VideoStore.getCurrentAccount().getAddress());
        phoneLabel.setText(VideoStore.getCurrentAccount().getPhoneNumber());
        passwordLabel.setText(VideoStore.getCurrentAccount().getPassword());
        userNameLabel.setText(VideoStore.getCurrentAccount().getUsername());
        accountTypeLabel.setText(VideoStore.getCurrentAccount().getAccountType());
        if (VideoStore.getCurrentAccount().getAccountType().equals("Vip Account")) {
            vipAccount.setVisible(true);
            vipPointLabel.setText(((VIPAccount) VideoStore.getCurrentAccount()).getVipPoint() + " Points");
            guestAccount.setVisible(false);
            regularAccount.setVisible(false);
        } else if (VideoStore.getCurrentAccount().getAccountType().equals("Regular Account")) {
            vipAccount.setVisible(false);
            guestAccount.setVisible(false);
            regularAccount.setVisible(true);
        } else if (VideoStore.getCurrentAccount().getAccountType().equals("Guest Account")) {
            vipAccount.setVisible(false);
            guestAccount.setVisible(true);
            regularAccount.setVisible(false);
        }
    }

    // Other categories button handle
    @FXML
    protected void onRentButton() throws Exception {

        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                WelcomeScreen.setScene3((Stage) nameDisplayLabel.getScene().getWindow());
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
    protected void onReturnButton() throws Exception {
        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                WelcomeScreen.setScene4((Stage) nameDisplayLabel.getScene().getWindow());
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
    protected void onViewHistoryButton() throws IOException {
        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                WelcomeScreen.setScene5((Stage) nameDisplayLabel.getScene().getWindow());
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
    protected void onExtendButton() throws Exception {

        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                if (VideoStore.getCurrentAccount() instanceof VIPAccount) {
                    WelcomeScreen.setScene6((Stage) nameDisplayLabel.getScene().getWindow());
                } else {
                    AlertMessage.error013();
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

    //
    @FXML
    protected void onLogOutButton() throws Exception {


        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                if (LogOut.LogOutAccount()) {
                    WelcomeScreen.setScene1((Stage) nameDisplayLabel.getScene().getWindow());
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
    protected void onNameEditButton() throws Exception {

        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                String newExtractName = newName.getText();
                if (ErrorHandle.customerNameValidate(newExtractName)) {
                    Account account = SearchEngine.searchCustomer(VideoStore.getCurrentAccount().getName());
                    account.setName(newExtractName);
                    fullNameLabel.setText(account.getName());
                    editNamePane.setVisible(false);
                    displayNamePane.setVisible(true);
//            account.getName();
                    Database.saveAccountData();
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
    protected void onNameCancelButton() throws Exception {
        displayNamePane.setVisible(true);
        editNamePane.setVisible(false);
    }

    @FXML
    protected void onAddressEditButton() throws Exception {

        loaderPane.setVisible(true);

        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                String newExtractAddress = newAddress.getText();
                if (ErrorHandle.customerAddressValidate(newExtractAddress)) {
                    Account account = SearchEngine.searchCustomer(VideoStore.getCurrentAccount().getAddress());
                    account.setAddress(newExtractAddress);
                    account.setAddress(newExtractAddress);
                    addressLabel.setText(account.getAddress());
                    displayAddressPane.setVisible(true);
                    editAddressPane.setVisible(false);
                    Database.saveAccountData();

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
    protected void onAddressCancelButton() throws Exception {
        displayAddressPane.setVisible(true);
        editAddressPane.setVisible(false);
    }

    @FXML
    protected void onPwdEditButton() throws Exception {
        editPwdPane.setVisible(true);
    }

    @FXML
    protected void onFirstNameEditButton() throws Exception {
        displayNamePane.setVisible(false);
        editNamePane.setVisible(true);
    }

    @FXML
    protected void onFirstAddressEditButton() throws Exception {
        displayAddressPane.setVisible(false);
        editAddressPane.setVisible(true);
    }

    // change password event
    @FXML
    protected void onSetConFirmPass() {
        loaderPane.setVisible(true);
        // Create a Task to perform the login process
        Task<Void> loginTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a time-consuming task
                Thread.sleep(300);

                // Perform the login process here

                // Simulate successful login

                return null;
            }
        };

        loginTask.setOnSucceeded(event -> {

            try {
                String currPass = currPwd.getText();
                String newPass = newPwd.getText();
                String confirmPass = confirmPwd.getText();

                // validate the data in pwd-changing section
//        if (currPass.equals(VideoStore.getCurrentAccount().getPassword())) {
                if (ErrorHandle.currPwdValidation(currPass)) {
                    if (ErrorHandle.customerPasswordValidate(newPass) && ErrorHandle.changePwdValidation(newPass, confirmPass)) {
                        VideoStore.getCurrentAccount().setPassword(newPass);
                        passwordLabel.setText(newPass);
                        editPwdPane.setVisible(false);
                        SuccessMessage.accept007();
                    }
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
    protected void onCancelPwdForm() {
        editPwdPane.setVisible(false);
    }

}
