module com.example.st200486894labweek2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
                            
    opens com.example.st200486894labweek2 to javafx.fxml;
    exports com.example.st200486894labweek2;
}