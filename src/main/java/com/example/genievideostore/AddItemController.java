package com.example.genievideostore;

import code.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.AlertMessage;
import utilities.ConfirmationMessage;
import utilities.LogOut;
import utilities.SuccessMessage;

public class AddItemController {
    @FXML
    private Pane pane;

    @FXML
    protected void onItemManagementButton() throws Exception {
        WelcomeScreen.setScene7((Stage) pane.getScene().getWindow());
    }
    @FXML
    protected void onAccountManagementButton() throws Exception {
        WelcomeScreen.setScene9((Stage) pane.getScene().getWindow());
    }

    @FXML
    protected void onResolveBanButton() throws Exception {
        WelcomeScreen.setScene8((Stage) pane.getScene().getWindow());
    }

    @FXML
    protected void onLogOutButton() throws Exception {
        if (LogOut.LogOutAccount()) {
            WelcomeScreen.setScene1((Stage) pane.getScene().getWindow());
        }
    }

    @FXML
    private TextArea titleArea = new TextArea();
    @FXML
    private TextArea feeArea = new TextArea();
    @FXML
    private TextArea stockArea = new TextArea();
    @FXML
    private TextArea yearArea = new TextArea();



    @FXML
    private MenuItem DVD;
    @FXML
    private MenuItem Record;
    @FXML
    private MenuItem Game;

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
    private MenuButton rentalTypeMenu;
    @FXML
    private MenuButton loanTypeMenu;

    @FXML
    private Button submit;
    @FXML
    private Label errorLabel;
    @FXML
    private Label genreLabel;

    String title;
    String rentalType;
    String loanType;
    int stock;
    double fee;
    int year;
    String genre = "";


    public void setDVDText(){
        rentalTypeMenu.setText("DVD");
        //System.out.println("DVD chosen");
        rentalType = "DVD";
        genreMenu.setVisible(true);
        genreLabel.setVisible(true);
    }

    public void setMovieText(){
        rentalTypeMenu.setText("Old Movie Record");
        //System.out.println("Record");
        rentalType = "Record";
        genreMenu.setVisible(true);
        genreLabel.setVisible(true);
    }


    public void setGameText(){
        rentalTypeMenu.setText("Game");
        //System.out.println("Game chosen");
        rentalType = "Game";
        genreMenu.setVisible(false);
        genreLabel.setVisible(false);
        genre.equals("");
        genreMenu.setText("");
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


    public void submit(ActionEvent e){
        try{
            title = titleArea.getText();
            stock = Integer.parseInt(stockArea.getText());
            fee = Double.parseDouble(feeArea.getText());
            year = Integer.parseInt(yearArea.getText());

            if (ConfirmationMessage.confirm007() == true) {
                createItem();
                SuccessMessage.accept009();
            }
        }

        catch (NumberFormatException exception ){
            AlertMessage.error017();
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }


    public void createItem(){
        if (rentalType == "DVD"){
            Item newDVD = new DVD(title, rentalType, loanType, stock, fee, year, genre);
            VideoStore.addItem(newDVD);
        }
        else if (rentalType == "Record"){
            Item newRecord = new OldMovieRecord(title, rentalType, loanType, stock, fee, year, genre);
            VideoStore.addItem(newRecord);
        }



        else if (rentalType == "Game"){
            Item newGame = new VideoGame(title, rentalType, loanType, stock, fee, year);
            VideoStore.addItem(newGame);
        }
    }

}
