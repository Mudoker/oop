package com.example.genievideostore;

import code.DVD;
import code.Item;
import code.OldMovieRecord;
import code.VideoStore;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import utilities.AlertMessage;
import utilities.ConfirmationMessage;
import utilities.LogOut;
import utilities.SuccessMessage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminItemController  {
    @FXML
    private Pane loaderPane;


    @FXML
    private TextArea IDArea = new TextArea();
    @FXML
    private TextArea titleArea = new TextArea();
    @FXML
    private TextArea rentalArea = new TextArea();
    @FXML
    private TextArea feeArea = new TextArea();
    @FXML
    private TextArea stockArea = new TextArea();
    @FXML
    private Pane originalPane;
    @FXML
    private Pane updatePane;




    @FXML
    private MenuItem twoDay;
    @FXML
    private MenuItem oneWeek;

    @FXML
    private MenuItem Horror;
    @FXML
    private MenuItem Comedy;
    @FXML
    private MenuItem Action;

    @FXML
    private MenuButton genreMenu;
    @FXML
    private MenuButton loanTypeMenu;

    @FXML
    private Label genreLabel;
    @FXML
    private Button updateButton = new Button();


    //super(id, title, rentalType, loanType, stock, rentalFee);
//        this.genre = genre;
    String ID;
    String title;
    String rentalType;
    String loanType;
    double fee;
    String genre = "";

    public void setHorrorType(){
        genreMenu.setText("Horror");
        genre = "Horror";
    }

    public void setActionType(){
        genreMenu.setText("Action");
        genre = "Action";
    }

    public void setComedyType(){
        genreMenu.setText("Comedy");
        genre = "Comedy";
    }


    public void setDayLoanType(){
        loanTypeMenu.setText("2-day");
        loanType = "2-day";
        //System.out.println("2day");
    }

    public void setWeekLoanType(){
        loanTypeMenu.setText("1-week");
        //System.out.println("7day");
        loanType = "1-week";
    }



    @FXML
    private GridPane pane;
    @FXML
    private MenuButton sortItemButton;
    @FXML
    private MenuButton filterItemButton;
    @FXML
    private TextField searchBar;
    private ArrayList<Item> itemDisplayList;


    @FXML
    public void initialize() {
        itemDisplayList = VideoStore.displayActiveItem();
        displayInGridPane(pane,VideoStore.displayActiveItem());
    }

    // Handle on clicking other category

//    @FXML
//    protected void onItemManagementButton() throws Exception {
//       WelcomeScreen.setScene7((Stage) pane.getScene().getWindow());
//    }
//    @FXML
//    protected void onAccountManagementButton() throws Exception {
//        WelcomeScreen.setScene9((Stage) pane.getScene().getWindow());
//    }
//
//    @FXML
//    protected void onResolveBanButton() throws Exception {
//        WelcomeScreen.setScene8((Stage) pane.getScene().getWindow());
//    }
//
//    @FXML
//    protected void onLogOutButton() throws Exception {
//        if (LogOut.LogOutAccount()) {
//            WelcomeScreen.setScene1((Stage) pane.getScene().getWindow());
//        }
//    }
//
//
//    // Content
//
//    @FXML
//    protected void onItemSortByID() {
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//        displayInGridPane(pane,VideoStore.displayItemSortByID(itemDisplayList));
//        sortItemButton.setText("ID");
//    }
//    @FXML
//    protected void onItemSortByTitle() {
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//        displayInGridPane(pane,VideoStore.displayItemSortByTitle(itemDisplayList));
//        sortItemButton.setText("Title");
//    }
//
//    @FXML
//    protected void onDVDFilter() {
//        itemDisplayList = VideoStore.displayDVDItem();
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//
//        if (sortItemButton.getText().equals("Title"))
//            displayInGridPane(pane,VideoStore.displayItemSortByTitle(itemDisplayList));
//        else {
//            displayInGridPane(pane,VideoStore.displayItemSortByID(itemDisplayList));
//        }
//        filterItemButton.setText("DVD");
//    }
//    @FXML
//    protected void onVideoGameFilter() {
//        itemDisplayList = VideoStore.displayVideoGameItem();
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//
//        if (sortItemButton.getText().equals("Title"))
//            displayInGridPane(pane,VideoStore.displayItemSortByTitle(itemDisplayList));
//        else {
//            displayInGridPane(pane,VideoStore.displayItemSortByID(itemDisplayList));
//        }
//        filterItemButton.setText("Video Game");
//    }
//    @FXML
//    protected void onOldRecordFilter() {
//        itemDisplayList = VideoStore.displayRecordItem();
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//
//        if (sortItemButton.getText().equals("Title"))
//            displayInGridPane(pane,VideoStore.displayItemSortByTitle(itemDisplayList));
//        else {
//            displayInGridPane(pane,VideoStore.displayItemSortByID(itemDisplayList));
//        }
//        filterItemButton.setText("Old Movie Record");
//    }
//
//    @FXML
//    protected void onStockFilter() {
//        itemDisplayList = VideoStore.displayItemWithStock();
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//
//        if (sortItemButton.getText().equals("Title"))
//            displayInGridPane(pane,VideoStore.displayItemSortByTitle(itemDisplayList));
//        else {
//            displayInGridPane(pane,VideoStore.displayItemSortByID(itemDisplayList));
//        }
//        filterItemButton.setText("Available Item");
//    }
//
//    @FXML
//    protected void onNoStockFilter() {
//        itemDisplayList = VideoStore.displayItemWithNoStock();
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//
//        if (sortItemButton.getText().equals("Title"))
//            displayInGridPane(pane,VideoStore.displayItemSortByTitle(itemDisplayList));
//        else {
//            displayInGridPane(pane,VideoStore.displayItemSortByID(itemDisplayList));
//        }
//        filterItemButton.setText("Unavailable Item");
//    }
//
//    @FXML
//    protected void onAllItemFilter() {
//        itemDisplayList = VideoStore.displayActiveItem();
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//
//        if (sortItemButton.getText().equals("Title"))
//            displayInGridPane(pane,VideoStore.displayItemSortByTitle(itemDisplayList));
//        else {
//            displayInGridPane(pane,VideoStore.displayItemSortByID(itemDisplayList));
//        }
//        filterItemButton.setText("All");
//    }
//
//    @FXML
//    protected void onFindIcon() {
//        ArrayList<Item> temp = new ArrayList<Item>();
//        String keyword = searchBar.getText();
//        for (Item item:itemDisplayList) {
//            if (item.getId().equals(keyword) || item.getTitle().equals(keyword)) {
//                temp.add(item);
//            }
//        }
//
//        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//
//        displayInGridPane(pane, temp);
//    }
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
            WelcomeScreen.setScene7((Stage) pane.getScene().getWindow());
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
                WelcomeScreen.setScene9((Stage) pane.getScene().getWindow());
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
                WelcomeScreen.setScene8((Stage) pane.getScene().getWindow());
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


    // Content

    @FXML
    protected void onItemSortByID () {

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
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
                displayInGridPane(pane, VideoStore.displayItemSortByID(itemDisplayList));
                sortItemButton.setText("ID");
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
    protected void onItemSortByTitle () {

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
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
                displayInGridPane(pane, VideoStore.displayItemSortByTitle(itemDisplayList));
                sortItemButton.setText("Title");            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onDVDFilter () {

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
                itemDisplayList = VideoStore.displayDVDItem();
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortItemButton.getText().equals("Title"))
                    displayInGridPane(pane, VideoStore.displayItemSortByTitle(itemDisplayList));
                else {
                    displayInGridPane(pane, VideoStore.displayItemSortByID(itemDisplayList));
                }
                filterItemButton.setText("DVD");            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onVideoGameFilter () {

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
                itemDisplayList = VideoStore.displayVideoGameItem();
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortItemButton.getText().equals("Title"))
                    displayInGridPane(pane, VideoStore.displayItemSortByTitle(itemDisplayList));
                else {
                    displayInGridPane(pane, VideoStore.displayItemSortByID(itemDisplayList));
                }
                filterItemButton.setText("Video Game");            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onOldRecordFilter () {

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
                itemDisplayList = VideoStore.displayRecordItem();
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortItemButton.getText().equals("Title"))
                    displayInGridPane(pane, VideoStore.displayItemSortByTitle(itemDisplayList));
                else {
                    displayInGridPane(pane, VideoStore.displayItemSortByID(itemDisplayList));
                }
                filterItemButton.setText("Old Movie Record");            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onStockFilter () {

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
                itemDisplayList = VideoStore.displayItemWithStock();
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortItemButton.getText().equals("Title"))
                    displayInGridPane(pane, VideoStore.displayItemSortByTitle(itemDisplayList));
                else {
                    displayInGridPane(pane, VideoStore.displayItemSortByID(itemDisplayList));
                }
                filterItemButton.setText("Available Item");            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onNoStockFilter () {

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
                itemDisplayList = VideoStore.displayItemWithNoStock();
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortItemButton.getText().equals("Title"))
                    displayInGridPane(pane, VideoStore.displayItemSortByTitle(itemDisplayList));
                else {
                    displayInGridPane(pane, VideoStore.displayItemSortByID(itemDisplayList));
                }
                filterItemButton.setText("Unavailable Item");            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onAllItemFilter () {

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
                itemDisplayList = VideoStore.displayActiveItem();
                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                if (sortItemButton.getText().equals("Title"))
                    displayInGridPane(pane, VideoStore.displayItemSortByTitle(itemDisplayList));
                else {
                    displayInGridPane(pane, VideoStore.displayItemSortByID(itemDisplayList));
                }
                filterItemButton.setText("All");            } catch (Exception e) {
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
                ArrayList <Item> temp = new ArrayList <Item>();
                String keyword = searchBar.getText();
                for (Item item : itemDisplayList) {
                    if (item.getId().equals(keyword) || item.getTitle().equals(keyword)) {
                        temp.add(item);
                    }
                }

                pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);

                displayInGridPane(pane, temp);            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Hide the loader icon
            loaderPane.setVisible(false);

        });
        Thread loginThread = new Thread(loginTask);
        loginThread.start();

    }

    @FXML
    protected void onAddItemIcon() throws Exception {
        WelcomeScreen.setScene10((Stage) pane.getScene().getWindow());
    }


    public void showItemInfo(Item item){
        IDArea.setText(item.getId());
        titleArea.setText(item.getTitle());
        rentalArea.setText(item.getRentalType());
        stockArea.setText(Integer.toString(item.getNumberOfCopies()));
        feeArea.setText(Double.toString(item.getRentalFee()));
        loanTypeMenu.setText(item.getLoanType());

        if (item instanceof DVD) {
            genreMenu.setVisible(true);
            genreLabel.setVisible(true);
            genreMenu.setText(((DVD) item).getGenre());

        }
        else if (item instanceof OldMovieRecord){
            genreMenu.setVisible(true);
            genreLabel.setVisible(true);
            genreMenu.setText(((OldMovieRecord) item).getGenre());
        }
    }


    public void displayInGridPane(GridPane pane, ArrayList<Item> itemListToDisplay) {
        int rowIndex = 1;
        for (Item item : itemListToDisplay) {
            Button update = new Button("Update");
            Button delete = new Button("X");
            Button addStock = new Button("+");
            Button deleteStock = new Button("-");
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
            pane.add(update, 8, rowIndex);
            pane.add(delete, 9, rowIndex);

            delete.setOnAction(event -> {
                VideoStore.deleteItem(item);
                refresh(VideoStore.displayActiveItem());
            });


            update.setOnAction(event -> {
//                item.display();
                showItemInfo(item);
                originalPane.setVisible(false);
                updatePane.setVisible(true);
                updateButton.setOnAction(actionEvent -> {
                    try {
                        item.setTitle(titleArea.getText());
                        item.setRentalFee(Double.parseDouble(feeArea.getText()));
                        item.setLoanType(loanTypeMenu.getText());
                        item.setNumberOfCopies(Integer.parseInt(stockArea.getText()));
                        if (item instanceof DVD){
                            ((DVD) item).setGenre(genre);
                        }
                        else if (item instanceof OldMovieRecord){
                            ((OldMovieRecord) item).setGenre(genre);
                        }

//                        item.display();
                        SuccessMessage.accept008();
                    } catch (NumberFormatException e) {
                        AlertMessage.error015();
                    }
                    try {
                        WelcomeScreen.setScene7((Stage) pane.getScene().getWindow());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                refresh(VideoStore.displayActiveItem());
            });

            pane.getRowConstraints().add(new RowConstraints(60));
            rowIndex++;
        }
    }
    public void refresh(ArrayList<Item> itemListToDisplay) {
        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
        displayInGridPane(pane,itemListToDisplay);
    }
}





