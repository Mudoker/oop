package com.example.genievideostore;

import code.Account;
import code.VideoStore;
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

import java.util.ArrayList;
import java.util.Objects;

public class AdminBanController {
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
	private ArrayList <Account> currentReturnList;
	private ArrayList <Account> accounts = new ArrayList <>();

	@FXML
	public void initialize () {
		nameDisplayLabel.setText("Admin");

		for (Account i : VideoStore.getAccountList()) {
			if (i.isBanStatus()) {
				accounts.add(i);
			}
		}
		displayInGridPane(pane, accounts);
		currentReturnList = new ArrayList <>();
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

				ArrayList <Account> tmp = new ArrayList <>();
				for (Account i : accounts) {
					if (Objects.equals(i.getName(), keyword) || Objects.equals(i.getId(), keyword)) {
						tmp.add(i);
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
				if (currentReturnList.isEmpty()) {
					AlertMessage.error009();

				}

				else if (ConfirmationMessage.confirm006()) {
					SuccessMessage.accept006();
					VideoStore.revolveBanStatus(currentReturnList);
					WelcomeScreen.setScene8((Stage) nameDisplayLabel.getScene().getWindow());
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

	public void displayInGridPane (GridPane pane, ArrayList <Account> itemListToDisplay) {
		int rowIndex = 1;
		for (Account rent : itemListToDisplay) {
			CheckBox returnBox = new CheckBox();

			returnBox.setOnMouseClicked(event -> {
				if (returnBox.isSelected()) {
					currentReturnList.add(rent);

				} else {
					currentReturnList.remove(rent);
				}
			});

			pane.add(new Label(rent.getId()), 0, rowIndex);
			pane.add(new Label(rent.getName()), 1, rowIndex);
			pane.add(new Label(rent.getPhoneNumber()), 2, rowIndex);
			pane.add(new Label(rent.getAddress()), 3, rowIndex);
			pane.add(returnBox, 4, rowIndex);
			pane.getRowConstraints().add(new RowConstraints(60));
			rowIndex++;
		}
	}


}
