module com.mycompany.pelaporankerusakan {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pelaporankerusakan to javafx.fxml;
    exports com.mycompany.pelaporankerusakan;
}
