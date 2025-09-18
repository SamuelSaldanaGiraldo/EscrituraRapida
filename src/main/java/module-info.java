module com.example.miniproyecto1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens com.example.miniproyecto1.controller to javafx.fxml;
    exports com.example.miniproyecto1;
}