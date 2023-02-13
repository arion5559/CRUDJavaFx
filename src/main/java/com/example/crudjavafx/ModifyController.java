package com.example.crudjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtVitalidad;
    @FXML
    private TextField txtFuerza;
    @FXML
    private TextField txtDestreza;
    @FXML
    private TextField txtMagia;
    @FXML
    private TextField txtDinero;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnAumentarVitalidad;
    @FXML
    private Button btnAumentarFuerza;
    @FXML
    private Button btnAumentarDestreza;
    @FXML
    private Button btnAumentarMagia;
    @FXML
    private Button btnRestarVitalidad;
    @FXML
    private Button btnRestarFuerza;
    @FXML
    private Button btnRestarDestreza;
    @FXML
    private Button btnRestarMagia;

    @FXML
    void modify(ActionEvent event) throws SQLException {
        ResultSet rs = DatabaseConnection.execute("SELECT * FROM characters WHERE name = '" + txtNombre.getText() + "'");
        if (rs.isBeforeFirst()) {
            DatabaseConnection.execute("UPDATE characters SET vitalidad = " + txtVitalidad.getText() + ", fuerza = " + txtFuerza.getText() + ", " +
                    "destreza = " + txtDestreza.getText() + ", magia = " + txtMagia.getText() + ", dinero = " + txtDinero.getText() + " WHERE name = '" + txtNombre.getText() + "'");
            showAlertInfo(event, "Personaje modificado correctamente");
        } else {
            showAlertInfo(event, "El personaje no existe");
        }

    }

    void showAlertInfo(ActionEvent event, String showText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("LogIn");
        alert.setTitle("Alert!!!");
        alert.setContentText(showText);
        alert.showAndWait();
    }

    @FXML
    void cancel(ActionEvent event) {
        btnCancel.getScene().getWindow().hide();
    }

    @FXML
    void aumentarVitalidad(ActionEvent event) {
        int vitalidad = Integer.parseInt(txtVitalidad.getText());
        vitalidad++;
        txtVitalidad.setText(String.valueOf(vitalidad));
    }

    @FXML
    void aumentarFuerza(ActionEvent event) {
        int fuerza = Integer.parseInt(txtFuerza.getText());
        fuerza++;
        txtFuerza.setText(String.valueOf(fuerza));
    }

    @FXML
    void aumentarDestreza(ActionEvent event) {
        int destreza = Integer.parseInt(txtDestreza.getText());
        destreza++;
        txtDestreza.setText(String.valueOf(destreza));
    }

    @FXML
    void aumentarMagia(ActionEvent event) {
        int magia = Integer.parseInt(txtMagia.getText());
        magia++;
        txtMagia.setText(String.valueOf(magia));
    }

    @FXML
    void restarVitalidad(ActionEvent event) {
        int vitalidad = Integer.parseInt(txtVitalidad.getText());
        vitalidad--;
        txtVitalidad.setText(String.valueOf(vitalidad));
    }

    @FXML
    void restarFuerza(ActionEvent event) {
        int fuerza = Integer.parseInt(txtFuerza.getText());
        fuerza--;
        txtFuerza.setText(String.valueOf(fuerza));
    }

    @FXML
    void restarDestreza(ActionEvent event) {
        int destreza = Integer.parseInt(txtDestreza.getText());
        destreza--;
        txtDestreza.setText(String.valueOf(destreza));
    }

    @FXML
    void restarMagia(ActionEvent event) {
        int magia = Integer.parseInt(txtMagia.getText());
        magia--;
        txtMagia.setText(String.valueOf(magia));
    }

    public void initialize() throws SQLException {
        ListadoPersonajesController listado = new ListadoPersonajesController();
        Personajes personajes = null;
        ResultSet rs = DatabaseConnection.execute("SELECT FROM personajes WHERE ID = " + listado.getIdPersonaje());
        while (rs.next()) {
            personajes = new Personajes(rs.getInt("ID"), rs.getString("nombre"),
                    rs.getInt("vitalidad"), rs.getInt("fuerza"), rs.getInt("destreza"),
                    rs.getInt("magia"), rs.getInt("dinero"), rs.getInt("IDUsuario"));
        }
        txtNombre.setText(personajes.getNombre());
        txtVitalidad.setText(String.valueOf(personajes.getNivelVitalidad()));
        txtFuerza.setText(String.valueOf(personajes.getNivelFuerza()));
        txtDestreza.setText(String.valueOf(personajes.getNivelDestreza()));
        txtMagia.setText(String.valueOf(personajes.getNivelMagia()));
        txtDinero.setText(String.valueOf(personajes.getDinero()));
    }

}
