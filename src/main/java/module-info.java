module com.presensimahasiswa {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.presensimahasiswa to javafx.fxml;

    exports com.presensimahasiswa;
}
