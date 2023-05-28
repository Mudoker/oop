module com.example.geniestore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.genievideostore to javafx.fxml;
    exports com.example.genievideostore;
}