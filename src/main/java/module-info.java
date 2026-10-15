module com.example.fase3dmd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.fase3dmd to javafx.fxml;
    opens com.example.fase3dmd.controller to javafx.fxml;

    exports com.example.fase3dmd;
}