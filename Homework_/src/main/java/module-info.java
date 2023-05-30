module com.example.homework_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.homework_ to javafx.fxml;
    exports com.example.homework_;
}