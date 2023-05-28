package com.example.genievideostore;

import code.Account;
import code.VideoStore;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import utilities.LogOut;

import java.io.IOException;
import java.util.ArrayList;

public class AdminAccountController {
    public Pane loaderPane;
    @FXML
    private GridPane paneA;
    @FXML
    private TextField searchBar;
    @FXML
    private Button AccountManage;
    @FXML
    private MenuButton filterAccountButton;
    @FXML
    private MenuButton sortAccountButton;
    private ArrayList <Account> accountDisplayList;


    @FXML
    public void initialize () {
        accountDisplayList = VideoStore.displayAllAccount();
        displayInGridPane(paneA, VideoStore.displayAllAccount());

    }

    // Handle on clicking other category
    @FXML
    protected void onItemManagementButton () throws Exception {
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
                WelcomeScreen.setScene7((Stage) paneA.getScene().getWindow());
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
    protected void onAccountManagementButton () throws Exception {
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
                WelcomeScreen.setScene9((Stage) paneA.getScene().getWindow());
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
    protected void onResolveBanButton () throws Exception {
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
                WelcomeScreen.setScene8((Stage) paneA.getScene().getWindow());
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
    protected void onLogOutButton () throws Exception {

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
                if (LogOut.LogOutAccount()) {
                    WelcomeScreen.setScene1((Stage) paneA.getScene().getWindow());
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


    // Content

    @FXML
    protected void onAccountSortByID () throws IOException {

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
                paneA.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
                displayInGridPane(paneA, VideoStore.displayAccountSortByID(accountDisplayList));
                sortAccountButton.setText("ID");
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
    protected void onAccountSortByName () throws IOException {

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
                paneA.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
                displayInGridPane(paneA, VideoStore.displayAccountSortByName(accountDisplayList));
                sortAccountButton.setText("Name");
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
    protected void onGuestFilter () {

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
                accountDisplayList = VideoStore.displayGuestAccount();
                paneA.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortAccountButton.getText().equals("Guest"))
                    displayInGridPane(paneA, VideoStore.displayAccountSortByName(accountDisplayList));
                else {
                    displayInGridPane(paneA, VideoStore.displayAccountSortByID(accountDisplayList));
                }
                filterAccountButton.setText("Guest");			} catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onRegularFilter () {

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
                accountDisplayList = VideoStore.displayRegularAccount();
                paneA.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortAccountButton.getText().equals("Regular"))
                    displayInGridPane(paneA, VideoStore.displayAccountSortByName(accountDisplayList));
                else {
                    displayInGridPane(paneA, VideoStore.displayAccountSortByID(accountDisplayList));
                }
                filterAccountButton.setText("Regular");			} catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onVipFilter () {

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
                accountDisplayList = VideoStore.displayVIPAccount();
                paneA.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortAccountButton.getText().equals("VIP"))
                    displayInGridPane(paneA, VideoStore.displayAccountSortByName(accountDisplayList));
                else {
                    displayInGridPane(paneA, VideoStore.displayAccountSortByID(accountDisplayList));
                }
                filterAccountButton.setText("VIP");			} catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onAllFilter () {

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
                accountDisplayList = VideoStore.displayAllAccount();
                paneA.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortAccountButton.getText().equals("All"))
                    displayInGridPane(paneA, VideoStore.displayAccountSortByName(accountDisplayList));
                else {
                    displayInGridPane(paneA, VideoStore.displayAccountSortByID(accountDisplayList));
                }
                filterAccountButton.setText("All");			} catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }


    @FXML
    protected void onFindIcon () {

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
                ArrayList <Account> temp = new ArrayList <Account>();
                String keyword = searchBar.getText();
                for (Account account : accountDisplayList) {
                    if (account.getId().equals(keyword) || account.getName().equals(keyword)) {
                        temp.add(account);
                    }
                }
                paneA.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
                displayInGridPane(paneA, temp);			} catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }


    public void displayInGridPane (GridPane pane, ArrayList <Account> accountListToDisplay) {
        int rowIndex = 1;
        for (Account account : accountListToDisplay) {
            Button plus = new Button("+");
            Button minus = new Button("-");
            Label quantityLabel = new Label("0");
            plus.setId("plusButton");
            minus.setId("minusButton");
            pane.add(new Label(account.getId()), 0, rowIndex);
            pane.add(new Label(account.getAddress()), 1, rowIndex);
            pane.add(new Label(account.getName()), 2, rowIndex);
            pane.add(new Label(account.getPhoneNumber()), 3, rowIndex);
            pane.add(new Label(account.getUsername()), 4, rowIndex);
            pane.add(new Label(account.getPassword()), 5, rowIndex);
            pane.add(new Label((account.isBanStatus()) ? "Ban" : "Not ban"), 6, rowIndex);
            pane.getRowConstraints().add(new RowConstraints(60));
            rowIndex++;
        }
    }


    //public void refresh(ArrayList<Item> itemListToDisplay) {
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//        displayInGridPane(pane,itemListToDisplay);
//    }
}
