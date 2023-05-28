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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ExtendRentController {
	public Label availablePoints;
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
	private Label totalPrice;
	private HashMap <Rent, Integer> currentRentalList;
	VIPAccount account = (VIPAccount) VideoStore.getCurrentAccount();

	@FXML
	public void initialize () {
		nameDisplayLabel.setText(VideoStore.getCurrentAccount().getName());
		availablePoints.setText("Your points: " + String.valueOf(account.getVipPoint()));
		ArrayList <Rent> rents = new ArrayList <>();
		for (Rent r : VideoStore.getCurrentAccount().getRentalList()) {
			if (! r.isReturnStatus()) {
				rents.add(r);
			}
		}

		displayInGridPane(pane, rents);
		currentRentalList = new HashMap <Rent, Integer>();
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
	protected void onReturnButton () throws Exception {
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
	protected void onLogOutButton () throws Exception {

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

	// Content
	@FXML
	protected void onRentIcon () throws IOException {

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
				if (currentRentalList.isEmpty()) {
					AlertMessage.error009();

				}
				else if (ConfirmationMessage.confirm005()) {
					account.extendRentDate(currentRentalList);
					WelcomeScreen.setScene6((Stage) nameDisplayLabel.getScene().getWindow());
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
				// Set up
				defaultPane.setVisible(false);
				searchPane.setVisible(true);
				resultPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);


				String keyword = searchBar.getText();

				displayInGridPane(resultPane, VideoStore.findRent(keyword));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			// Hide the loader icon
			loaderPane.setVisible(false);

		});
		Thread loginThread = new Thread(loginTask);
		loginThread.start();

	}


	public void updateTotalPoint (boolean isAdd) {

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
				int currentPrice = Integer.parseInt(totalPrice.getText());

				if (isAdd) {
					currentPrice += 50;
				} else {
					currentPrice -= 50;
				}

				totalPrice.setText(String.valueOf(currentPrice));
			} catch (Exception e) {
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
		AtomicBoolean hidePlus = new AtomicBoolean(true);
		for (Rent item : itemListToDisplay) {
			Button plus = new Button("+");
			Button minus = new Button("-");
			Label quantityLabel = new Label("0");
			plus.setId("plusButton");
			minus.setId("minusButton");
			pane.add(new Label(item.getRentItem().getId()), 0, rowIndex);
			pane.add(new Label(item.getRentItem().getRentalType()), 1, rowIndex);
			pane.add(new Label(item.getRentItem().getTitle()), 2, rowIndex);

			if (item.getRentItem() instanceof DVD)
				pane.add(new Label(((DVD) item.getRentItem()).getGenre()), 3, rowIndex);
			else if (item.getRentItem() instanceof OldMovieRecord)
				pane.add(new Label(((OldMovieRecord) item.getRentItem()).getGenre()), 3, rowIndex);

//			pane.add(new Label(item.getRentItem().getLoanType()), 4, rowIndex);
//			pane.add(new Label(Integer.toString(item.getRentItem().getNumberOfCopies())), 5, rowIndex);
//			pane.add(new Label(Double.toString(item.getRentItem().getRentalFee())), 6, rowIndex);
//			pane.add(new Label((item.getRentItem().isRentalStatus()) ? "Available" : "Unavailable"), 7, rowIndex);
			Calendar start = Calendar.getInstance();
			start.setTime(Date.from(Instant.ofEpochMilli(item.getDateStart())));

			int day1 = start.get(Calendar.DAY_OF_MONTH);
			int month1 = start.get(Calendar.MONTH) + 1; // Months are zero-based
			int year1 = start.get(Calendar.YEAR);

			Calendar end = Calendar.getInstance();
			end.setTime(Date.from(Instant.ofEpochMilli(item.getDateEnd())));

			AtomicInteger day2 = new AtomicInteger(end.get(Calendar.DAY_OF_MONTH));
			AtomicInteger month2 = new AtomicInteger(end.get(Calendar.MONTH) + 1); // Months are zero-based
			AtomicInteger year2 = new AtomicInteger(end.get(Calendar.YEAR));

			Label dueDate = new Label(day2 + "/" + month2 + "/" + year2);
			dueDate.setId("newDueDate");
			pane.add(new Label(day1 + "/" + month1 + "/" + year1), 4, rowIndex);
			pane.add(dueDate, 5, rowIndex);
			pane.add(quantityLabel, 7, rowIndex);
			pane.add(plus, 6, rowIndex);
			pane.add(minus, 8, rowIndex);
			minus.setVisible(false);

			plus.setOnMouseClicked(mouseEvent -> {
				// Handle on UI action
				minus.setVisible(true);
				int currentQuantity = Integer.parseInt(quantityLabel.getText());
				end.setTime(Date.from(Instant.ofEpochMilli(end.getTimeInMillis() + 86400000)));
				day2.set(end.get(Calendar.DAY_OF_MONTH));
				month2.set(end.get(Calendar.MONTH) + 1); // Months are zero-based
				year2.set(end.get(Calendar.YEAR));
				dueDate.setText(day2 + "/" + month2 + "/" + year2);

				quantityLabel.setText(Integer.toString(currentQuantity + 1));
				updateTotalPoint(true);


				// Back-end action

				if (! currentRentalList.containsKey(item)) {
					currentRentalList.put(item, 1);
				} else {
					currentRentalList.put(item, currentRentalList.get(item) + 1);
				}
			});

			minus.setOnMouseClicked(mouseEvent -> {
				end.setTime(Date.from(Instant.ofEpochMilli(end.getTimeInMillis() - 86400000)));
				day2.set(end.get(Calendar.DAY_OF_MONTH));
				month2.set(end.get(Calendar.MONTH) + 1); // Months are zero-based
				year2.set(end.get(Calendar.YEAR));
				dueDate.setText(day2 + "/" + month2 + "/" + year2);
				int currentQuantity = Integer.parseInt(quantityLabel.getText());
				if (currentQuantity == 1) minus.setVisible(false);

				quantityLabel.setText(Integer.toString(currentQuantity - 1));
				updateTotalPoint(false);
				if (currentRentalList.get(item) == 1) {
					currentRentalList.remove(item);
				} else {
					currentRentalList.put(item, currentRentalList.get(item) - 1);
				}
			});

			pane.getRowConstraints().add(new RowConstraints(60));
			rowIndex++;
		}
	}


//	public void refresh (ArrayList <item.getRentItem()> item.getRentItem()ListToDisplay) {
//		pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null);
//		displayInGridPane(pane, item.getRentItem()ListToDisplay);
//	}
}
