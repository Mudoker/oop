package com.example.genievideostore;

import code.*;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import utilities.AlertMessage;
import utilities.ConfirmationMessage;
import utilities.LogOut;
import utilities.SuccessMessage;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ReturnController {
    public Pane loaderPane;
    @FXML
    private GridPane pane;
    @FXML
    private Label nameDisplayLabel;
    @FXML
    private TextField searchBar;
    @FXML
    private ScrollPane defaultPane;
    @FXML
    private ScrollPane searchPane;
    @FXML
    private GridPane resultPane;
    @FXML
    private Label returnCountLabel;
    private ArrayList <Rent> currentReturnList;

    @FXML
    public void initialize () {
        nameDisplayLabel.setText(VideoStore.getCurrentAccount().getName());
        displayInGridPane(pane, VideoStore.displayRentalItem());
        currentReturnList = new ArrayList <Rent>();
    }


    // Handle on clicking other category
    @FXML
    protected void onHomePageButton () throws Exception {

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
                WelcomeScreen.setScene2((Stage) pane.getScene().getWindow());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);
            // Add any additional logic or UI updates here

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();
    }

    @FXML
    protected void onRentButton () throws Exception {

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
    protected void onReturnButton () throws Exception {
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
                    WelcomeScreen.setScene1((Stage) pane.getScene().getWindow());
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
    protected void onHistoryButton () throws Exception {

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
                WelcomeScreen.setScene5((Stage) pane.getScene().getWindow());
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
    protected void onExtendButton () throws Exception {

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
    // Content


    @FXML
    protected void onFindIcon () {

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
// Set up
                defaultPane.setVisible(false);
                searchPane.setVisible(true);
                resultPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);


                String keyword = searchBar.getText();
                ArrayList <Rent> tmp = new ArrayList <>();
                for (Rent i : VideoStore.getCurrentAccount().getRentalList()) {
                    if (! i.isReturnStatus()) {
                        if (Objects.equals(i.getRentItem().getId(), keyword) || Objects.equals(i.getRentItem().getTitle(), keyword)) {
                            tmp.add(i);
                        }
                    }
                }
                displayInGridPane(resultPane, tmp);
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
    protected void onReturnIcon () throws Exception {

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
                if (currentReturnList.isEmpty()) {
                    AlertMessage.error009();

                }

                else if (ConfirmationMessage.confirm003()) {
                    SuccessMessage.accept003();
                    VideoStore.returnItem(currentReturnList);
                    WelcomeScreen.setScene4((Stage) nameDisplayLabel.getScene().getWindow());
                }            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    public void displayInGridPane (GridPane pane, ArrayList <Rent> itemListToDisplay) {
        int rowIndex = 1;
        for (Rent rent : itemListToDisplay) {
            CheckBox returnBox = new CheckBox();

            returnBox.setOnMouseClicked(event -> {
                if (returnBox.isSelected()) {
                    currentReturnList.add(rent);
                    updateTotalReturnSize(true);

                } else {
                    currentReturnList.remove(rent);
                    updateTotalReturnSize(false);
                }
            });

            pane.add(new Label(rent.getRentItem().getId()), 0, rowIndex);
            pane.add(new Label(rent.getRentItem().getRentalType()), 1, rowIndex);
            pane.add(new Label(rent.getRentItem().getTitle()), 2, rowIndex);

            if (rent.getRentItem() instanceof DVD)
                pane.add(new Label(((DVD) rent.getRentItem()).getGenre()), 3, rowIndex);
            else if (rent.getRentItem() instanceof OldMovieRecord)
                pane.add(new Label(((OldMovieRecord) rent.getRentItem()).getGenre()), 3, rowIndex);


            Calendar start = Calendar.getInstance();
            start.setTime(Date.from(Instant.ofEpochMilli(rent.getDateStart())));

            int day1 = start.get(Calendar.DAY_OF_MONTH);
            int month1 = start.get(Calendar.MONTH) + 1; // Months are zero-based
            int year1 = start.get(Calendar.YEAR);

            Calendar end = Calendar.getInstance();
            end.setTime(Date.from(Instant.ofEpochMilli(rent.getDateEnd())));

            int day2 = end.get(Calendar.DAY_OF_MONTH);
            int month2 = end.get(Calendar.MONTH) + 1; // Months are zero-based
            int year2 = end.get(Calendar.YEAR);

            pane.add(new Label(day1 + "/" + month1 + "/" + year1), 4, rowIndex);
            pane.add(new Label(day2 + "/" + month2 + "/" + year2), 5, rowIndex);
            pane.add(returnBox, 6, rowIndex);
            pane.getRowConstraints().add(new RowConstraints(60));
            rowIndex++;

        }
    }

    public void updateTotalReturnSize (boolean isAdd) {
        int count = Integer.parseInt(returnCountLabel.getText());
        if (isAdd) {
            count++;
        } else {
            count--;
        }
        returnCountLabel.setText(String.valueOf(count));
    }
}
