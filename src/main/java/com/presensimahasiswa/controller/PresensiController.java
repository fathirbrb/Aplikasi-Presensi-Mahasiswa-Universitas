package com.presensimahasiswa.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.sql.*;

public class PresensiController {
    @FXML
    private TextField fieldNama;
    @FXML
    private DatePicker fieldTanggal;
    @FXML
    private ComboBox<String> fieldStatus;
    @FXML
    private Button btnSimpan;

    @FXML
    private void handleSimpan(ActionEvent event) {
        String nama = fieldNama.getText();
        String tanggal = fieldTanggal.getValue().toString();
        String status = fieldStatus.getValue();

        try (Connection conn = DatabaseConnection.connect()) {
            String query = "INSERT INTO presensi (id_mahasiswa, tanggal, status) "
                    + "SELECT id, ?, ? FROM mahasiswa WHERE nama = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, tanggal);
            pstmt.setString(2, status);
            pstmt.setString(3, nama);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
