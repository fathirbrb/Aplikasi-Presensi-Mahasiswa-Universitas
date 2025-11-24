package com.presensimahasiswa.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import application.Mahasiswa;
import java.sql.*;

public class MainController {
    @FXML
    private TableView<Mahasiswa> tableMahasiswa;
    @FXML
    private TableColumn<Mahasiswa, String> colNama;
    @FXML
    private TableColumn<Mahasiswa, String> colNpm;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnPresensi;
    private ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(cellData -> cellData.getValue().getNama());
        colNpm.setCellValueFactory(cellData -> cellData.getValue().getNpm());
        tableMahasiswa.setItems(mahasiswaList);
        loadData();
    }

    private void loadData() {
        try (Connection conn = DatabaseConnection.connect()) {
            String query = "SELECT * FROM mahasiswa";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                mahasiswaList.add(new Mahasiswa(rs.getString("nama"), rs.getString("npm")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleTambah(ActionEvent event) {
    }

    @FXML
    private void handlePresensi(ActionEvent event) {
    }
}
