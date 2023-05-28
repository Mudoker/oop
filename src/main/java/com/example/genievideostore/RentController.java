package com.example.genievideostore;

import code.*;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class RentController {
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
    private Label totalPrice;
    @FXML
    private Pane normalRentPane;
    @FXML
    private Pane VIPModePane;
    @FXML
    private Label vipPointLabel;
    @FXML
    private Label totalVipPoint;
    private HashMap <Item, Integer> currentRentalList;

    @FXML
    public void initialize () {
        nameDisplayLabel.setText(VideoStore.getCurrentAccount().getName());
        normalRentPane.setVisible(normalRentPane.isVisible());
        VIPModePane.setVisible(VIPModePane.isVisible());
        displayInGridPane(pane, VideoStore.displayActiveItem());
        currentRentalList = new HashMap <Item, Integer>();
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
    protected void onRentIcon () throws IOException {

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
                if (currentRentalList.isEmpty()) {
                    AlertMessage.error009();

                }


                else if (ConfirmationMessage.confirm002()) {
                    VideoStore.rentNewItem(currentRentalList);
                    totalPrice.setText("0");
                    refresh(VideoStore.displayActiveItem());
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

                String keyword = searchBar.getText();
                Item item = VideoStore.findItem(keyword);
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
                if (item != null) {
                    ArrayList <Item> findItem = new ArrayList <>();
                    findItem.add(item);
                    displayInGridPane(pane, findItem);
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
    protected void onSwitchVIPRent () {

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
                if (! (VideoStore.getCurrentAccount() instanceof VIPAccount)) {
                    AlertMessage.error010();
                    // Hide the loader icon
                    loaderPane.setVisible(false);
                    return;
                }

                normalRentPane.setVisible(false);
                VIPModePane.setVisible(true);
                refresh(VideoStore.displayActiveItem());

                vipPointLabel.setText((((VIPAccount) VideoStore.getCurrentAccount()).getVipPoint()) + " VIP Points remaining");
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
    protected void onSwitchNormalRent () {

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
                normalRentPane.setVisible(true);
                VIPModePane.setVisible(false);
                refresh(VideoStore.displayActiveItem());
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
    protected void onSpecialRentIcon () {

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
                if (currentRentalList.isEmpty()) {
                    AlertMessage.error009();
                }

                else if (Integer.parseInt(totalVipPoint.getText()) > ((VIPAccount) VideoStore.getCurrentAccount()).getVipPoint()) {
                    AlertMessage.error011();
                }

                else if (ConfirmationMessage.confirm002()) {
                    VideoStore.rentFreeVIP(currentRentalList);
                    totalVipPoint.setText("0");
                    // Automatically refresh the scene
                    refresh(VideoStore.displayActiveItem());
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


    public void updateTotalPrice (boolean isAdd, Item item) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double currentPrice = Double.parseDouble(totalPrice.getText());

        if (isAdd) {
            currentPrice += item.getRentalFee();
        } else {
            currentPrice -= item.getRentalFee();
        }

        totalPrice.setText(decimalFormat.format(currentPrice));
    }

    public void updateTotalVIPPoint (boolean isAdd) {
        int currentConsumeVipPoint = Integer.parseInt(totalVipPoint.getText());
        if (isAdd) {
            currentConsumeVipPoint += 100;
        } else {
            currentConsumeVipPoint -= 100;
        }
        totalVipPoint.setText(String.valueOf(currentConsumeVipPoint));
    }

    public void displayInGridPane (GridPane pane, ArrayList <Item> itemListToDisplay) {
        int rowIndex = 1;
        for (Item item : itemListToDisplay) {
            Button plus = new Button("+");
            Button minus = new Button("-");
            Label quantityLabel = new Label("0");
            plus.setId("plusButton");
            minus.setId("minusButton");
            pane.add(new Label(item.getId()), 0, rowIndex);
            pane.add(new Label(item.getRentalType()), 1, rowIndex);
            pane.add(new Label(item.getTitle()), 2, rowIndex);

            if (item instanceof DVD)
                pane.add(new Label(((DVD) item).getGenre()), 3, rowIndex);
            else if (item instanceof OldMovieRecord)
                pane.add(new Label(((OldMovieRecord) item).getGenre()), 3, rowIndex);

            pane.add(new Label(item.getLoanType()), 4, rowIndex);
            pane.add(new Label(Integer.toString(item.getNumberOfCopies())), 5, rowIndex);
            pane.add(new Label(Double.toString(item.getRentalFee())), 6, rowIndex);
            pane.add(new Label((item.isRentalStatus()) ? "Available" : "Unavailable"), 7, rowIndex);
            pane.add(quantityLabel, 9, rowIndex);
            if (item.isRentalStatus()) {
                pane.add(plus, 8, rowIndex);
                pane.add(minus, 10, rowIndex);
                minus.setVisible(false);

                plus.setOnMouseClicked(mouseEvent -> {
                    // Handle on UI action
                    minus.setVisible(true);
                    int currentQuantity = Integer.parseInt(quantityLabel.getText());
                    if (currentQuantity == item.getNumberOfCopies() - 1)
                        plus.setVisible(false);

                    quantityLabel.setText(Integer.toString(currentQuantity + 1));

                    updateTotalVIPPoint(true);
                    updateTotalPrice(true, item);


                    // Back-end action

                    if (! currentRentalList.containsKey(item)) {
                        currentRentalList.put(item, 1);
                    } else {
                        currentRentalList.put(item, currentRentalList.get(item) + 1);
                    }
                });

                minus.setOnMouseClicked(mouseEvent -> {
                    plus.setVisible(true);
                    int currentQuantity = Integer.parseInt(quantityLabel.getText());
                    if (currentQuantity == 1)
                        minus.setVisible(false);

                    quantityLabel.setText(Integer.toString(currentQuantity - 1));
                    updateTotalVIPPoint(false);
                    updateTotalPrice(false, item);

                    if (currentRentalList.get(item) == 1) {
                        currentRentalList.remove(item);
                    } else {
                        currentRentalList.put(item, currentRentalList.get(item) - 1);
                    }
                });
            }
            pane.getRowConstraints().add(new RowConstraints(60));
            rowIndex++;
        }
    }

    public void refresh (ArrayList <Item> itemListToDisplay) {
        currentRentalList.clear();
        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
        displayInGridPane(pane, VideoStore.displayActiveItem());
        totalVipPoint.setText("0");
        totalPrice.setText("0");
    }
}
