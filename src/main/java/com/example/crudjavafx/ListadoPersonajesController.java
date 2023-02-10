package com.example.crudjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListadoPersonajesController {
    @FXML
    private TableView tablePersonajes;

    @FXML
    private Button btnNuevoPersonaje;

    @FXML
    private Button btnEditarPersonaje;

    @FXML
    private Button btnEliminarPersonaje;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnBuscar;

    @FXML
    private TextField txtBuscar;

    @FXML
    private ComboBox<String> cmbBuscar;

    public void initialize() throws SQLException {
        ResultSet rs = null;
        rs = DatabaseConnection.execute("SELECT * FROM personajes WHERE IdUsuario = " + Main.getUser().getID());
        while (rs.next()) {
            tablePersonajes.getItems().add(
                    new Personajes(rs.getInt("ID"), rs.getString("Nombre"),
                    rs.getInt("Vitalidad"), rs.getInt("Fuerza"),
                            rs.getInt("Destreza"),
                            rs.getInt("Magia"),
                            rs.getFloat("Dinero"),
                            rs.getInt("IdUsuario")));
        }
        cmbBuscar.getItems().addAll("ID", "Nombre", "Vitalidad", "Fuerza", "Destreza", "Magia", "Dinero", "IdUsuario");
    }

    @FXML
    void buscar() throws SQLException {
        ResultSet rs = null;
        String buscar = txtBuscar.getText();
        String campo = cmbBuscar.getValue();
        tablePersonajes.getItems().clear();
        rs = DatabaseConnection.execute("SELECT * FROM personajes WHERE " + campo + " LIKE '%" + buscar + "%' AND IdUsuario = " + Main.getUser().getID());
        while (rs.next()) {
            tablePersonajes.getItems().add(
                    new Personajes(rs.getInt("ID"), rs.getString("Nombre"),
                            rs.getInt("Vitalidad"), rs.getInt("Fuerza"),
                            rs.getInt("Destreza"),
                            rs.getInt("Magia"),
                            rs.getFloat("Dinero"),
                            rs.getInt("IdUsuario")));
        }
    }

    @FXML
    void create() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new-character-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Nuevo Personaje");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    void modify() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("modify-character-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Modificar Personaje");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
