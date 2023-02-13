package com.example.crudjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListadoPersonajesController {
    @FXML
    private TableView<Personajes> tablePersonajes;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnEliminate;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnBuscar;

    @FXML
    private TextField txtBuscar;

    @FXML
    private ComboBox<String> comboBuscar;

    @FXML
    private TableColumn<Personajes, Integer> columnID;

    @FXML
    private TableColumn<Personajes, String> columnNombre;

    @FXML
    private TableColumn<Personajes, Integer> columnVitalidad;

    @FXML
    private TableColumn<Personajes, Integer> columnFuerza;

    @FXML
    private TableColumn<Personajes, Integer> columnDestreza;

    @FXML
    private TableColumn<Personajes, Integer> columnMagia;

    @FXML
    private TableColumn<Personajes, Float> columnDinero;

    @FXML
    private TableColumn<Personajes, Integer> columnIdUsuario;

    public void initialize() throws SQLException {
        ResultSet rs = null;
        rs = DatabaseConnection.execute("SELECT * FROM personajes WHERE IdUsuario = " + Main.getUser().getID());
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        columnVitalidad.setCellValueFactory(new PropertyValueFactory<>("nivelVitalidad"));
        columnFuerza.setCellValueFactory(new PropertyValueFactory<>("nivelFuerza"));
        columnDestreza.setCellValueFactory(new PropertyValueFactory<>("nivelDestreza"));
        columnMagia.setCellValueFactory(new PropertyValueFactory<>("nivelMagia"));
        columnDinero.setCellValueFactory(new PropertyValueFactory<>("Dinero"));
        columnIdUsuario.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        while (rs.next()) {
            tablePersonajes.getItems().add(
                    new Personajes(rs.getInt("ID"), rs.getString("Nombre"),
                    rs.getInt("Vitalidad"), rs.getInt("Fuerza"),
                            rs.getInt("Destreza"),
                            rs.getInt("Magia"),
                            rs.getFloat("Dinero"),
                            rs.getInt("IdUsuario")));
        }
        // Puedes arreglar esto por favor?
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "ID",
                        "Nombre",
                        "Vitalidad",
                        "Fuerza",
                        "Destreza",
                        "Magia",
                        "Dinero"
                );

        comboBuscar.setItems(options);
        comboBuscar.setValue("Nombre");
    }

    @FXML
    void buscar() throws SQLException {
        ResultSet rs = null;
        String buscar = txtBuscar.getText();
        String campo = null;
        tablePersonajes.getItems().clear();
        if (comboBuscar.getValue() != null) {
            campo = comboBuscar.getValue().toString();
        }
        if (campo != null) {
            rs = DatabaseConnection.execute("SELECT * FROM personajes WHERE " + campo + " LIKE '%" + buscar + "%' AND IdUsuario = " + Main.getUser().getID());
        } else {
            rs = DatabaseConnection.execute("SELECT * FROM personajes WHERE Nombre LIKE '%" + buscar + "%' AND IdUsuario = " + Main.getUser().getID());
        }
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
        Parent root = FXMLLoader.load(getClass().getResource("modify-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Modificar Personaje");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    @FXML
    public void eliminate() throws SQLException {
        Personajes personaje = (Personajes) tablePersonajes.getSelectionModel().getSelectedItem();
        DatabaseConnection.execute("DELETE FROM personajes WHERE ID = " + personaje.getId());
        tablePersonajes.getItems().remove(personaje);
    }

    public int getIdPersonaje() {
        Personajes personaje = tablePersonajes.getSelectionModel().getSelectedItem();
        return personaje.getId();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        Main.setUser(null);
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.setTitle("LogIn");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
