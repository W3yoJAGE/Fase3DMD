module com.example.fase3dmd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fase3dmd to javafx.fxml;
    exports com.example.fase3dmd;
}