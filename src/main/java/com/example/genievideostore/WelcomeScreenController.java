package com.example.genievideostore;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import code.*;
import javafx.scene.layout.Pane;
import utilities.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class WelcomeScreenController {

    public Pane loaderPane;
    @FXML
    private Button startButton;

    @FXML
    // Handle Submit Form Action
    protected void onGetStartButton() throws Exception {
        WelcomeScreen.setScene1((Stage)startButton.getScene().getWindow());
    }
}
