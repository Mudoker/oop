package com.example.genievideostore;

import code.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utilities.AlertMessage;
import utilities.ConfirmationMessage;
import utilities.LogOut;
import utilities.SuccessMessage;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HistoryViewController {
	// Display info
	@FXML
	private Label totalRented;
	@FXML
	private Label returnedRental;
	@FXML
	private Label currRental;
	public VBox primaryInfo;
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
		displayInGridPane(pane, VideoStore.getCurrentAccount().getRentalList());
		totalRented.setText(Integer.toString(VideoStore.getCurrentAccount().getRentalList().size()));
		returnedRental.setText(Integer.toString(VideoStore.getCurrentAccount().getSuccessfulRental()));
		currRental.setText(Integer.toString(VideoStore.getCurrentAccount().getPendingRental().size()));
	}


	// Handle on clicking other category
	@FXML
	protected void onHomePageButton () throws Exception {
		WelcomeScreen.setScene2((Stage) pane.getScene().getWindow());
	}

	@FXML
	protected void onRentButton () throws Exception {
		WelcomeScreen.setScene3((Stage) nameDisplayLabel.getScene().getWindow());
	}

	@FXML
	protected void onReturnButton () throws Exception {
		WelcomeScreen.setScene4((Stage) nameDisplayLabel.getScene().getWindow());
	}

	@FXML
	protected void onLogOutButton () throws Exception {
		if (LogOut.LogOutAccount()) {
			WelcomeScreen.setScene1((Stage) pane.getScene().getWindow());
		}
	}

	@FXML
	protected void onHistoryButton () throws Exception {
		WelcomeScreen.setScene5((Stage) pane.getScene().getWindow());
	}

	@FXML
	protected void onExtendButton () throws Exception {
		if (VideoStore.getCurrentAccount() instanceof VIPAccount) {
			WelcomeScreen.setScene6((Stage) nameDisplayLabel.getScene().getWindow());
		} else {
			AlertMessage.error013();
		}
	}
	// Content


	@FXML
	protected void onFindIcon () {
		// Set up
		defaultPane.setVisible(false);
		searchPane.setVisible(true);
		resultPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);


		String keyword = searchBar.getText();

		displayInGridPane(resultPane, VideoStore.findRent(keyword));
	}

	@FXML
	protected void onReturnIcon () throws Exception {
		if (currentReturnList.isEmpty()) {
			AlertMessage.error009();
			return;
		}

		if (ConfirmationMessage.confirm003()) {
			SuccessMessage.accept003();
			VideoStore.returnItem(currentReturnList);
			WelcomeScreen.setScene4((Stage) nameDisplayLabel.getScene().getWindow());
		}
	}

	public void displayInGridPane (GridPane pane, ArrayList <Rent> itemListToDisplay) {
		int rowIndex = 1;
		for (Rent rent : itemListToDisplay) {
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

			Calendar real = Calendar.getInstance();
			real.setTime(Date.from(Instant.ofEpochMilli(rent.getActualReturnDate())));

			int day3 = real.get(Calendar.DAY_OF_MONTH);
			int month3 = real.get(Calendar.MONTH) + 1; // Months are zero-based
			int year3 = real.get(Calendar.YEAR);
			pane.add(new Label(day1 + "/" + month1 + "/" + year1), 4, rowIndex);
			pane.add(new Label(day2 + "/" + month2 + "/" + year2), 5, rowIndex);
			if (rent.getActualReturnDate() == 0) {
				pane.add(new Label("Not Returned"), 6, rowIndex);
			} else {
				pane.add(new Label(day3 + "/" + month3 + "/" + year3), 6, rowIndex);
			}
			String status;
			if (rent.getActualReturnDate() > rent.getDateEnd()) {
				status = "Late";
			} else if (rent.getActualReturnDate() == 0 && System.currentTimeMillis() > rent.getDateEnd()) {
				status = "Late";
			} else if (rent.getActualReturnDate() == 0) {
				status = "";
			} else {
				status = "On Time";
			}
			pane.add(new Label(status), 7, rowIndex);
			pane.getRowConstraints().add(new RowConstraints(60));
			rowIndex++;
		}
	}

}
