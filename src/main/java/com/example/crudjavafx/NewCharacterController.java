package com.example.crudjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.sql.ResultSet;
import java.sql.SQLException;

public class NewCharacterController {
    @FXML
    private TextField txtNombre;
    @FXML
    private ComboBox<String> comboClase;
    @FXML
    private TextField txtDinero;
    @FXML
    private Button btnCreate;

    public void initialize() {
        comboClase.getItems().addAll("Caballero", "Ladrón", "Mago", "Guerrero", "Marginado");
    }


    void createCharacter() throws SQLException {
        String nombre = txtNombre.getText();
        String clase = comboClase.getValue();
        float dinero = Float.parseFloat(txtDinero.getText());
        int vitalidad = 0;
        int fuerza = 0;
        int destreza = 0;
        int magia = 0;
        switch (clase) {
            case "Caballero":
                vitalidad = 10;
                fuerza = 14;
                destreza = 7;
                magia = 3;
                break;
            case "Ladrón":
                vitalidad = 8;
                fuerza = 7;
                destreza = 16;
                magia = 3;
                break;
            case "Mago":
                vitalidad = 7;
                fuerza = 8;
                destreza = 5;
                magia = 14;
                break;
            case "Guerrero":
                vitalidad = 14;
                fuerza = 14;
                destreza = 3;
                magia = 3;
                break;
            case "Marginado":
                vitalidad = 9;
                fuerza = 9;
                destreza = 9;
                magia = 9;
                break;
        }
        DatabaseConnection.execute("INSERT INTO personajes (nombre, vitalidad, fuerza, destreza, magia, dinero, IdUsuario) VALUES " +
                "('" + nombre + "', " + vitalidad + ", " + fuerza + ", " + destreza + ", " + magia + ", " + dinero + ", " + Main.getUser().getID() + ")");
        ResultSet rs = DatabaseConnection.execute("SELECT * FROM personajes WHERE nombre = '" + nombre + "'");
        if (rs.next()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Personaje creado");
            alert.setHeaderText("Personaje creado");
            alert.setContentText("El personaje se ha creado correctamente");
            alert.showAndWait();
            txtNombre.setText("");
            comboClase.setValue("");
            txtDinero.setText("");
        }

    }

    @FXML
    void create(ActionEvent event) {
        if (txtNombre.getText().isEmpty() || comboClase.getValue().isEmpty() || txtDinero.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al crear el personaje");
            alert.setContentText("No puedes dejar ningún campo vacío");
            alert.showAndWait();
        } else {
            try {
                Float.parseFloat(txtDinero.getText());
                createCharacter();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Personaje creado");
                alert.setHeaderText("Personaje creado");
                alert.setContentText("El personaje se ha creado correctamente");
                alert.showAndWait();
            } catch (NumberFormatException | SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al crear el personaje");
                alert.setContentText("El dinero debe ser un número");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        // close the window
        Stage stage = (Stage) btnCreate.getScene().getWindow();
        stage.close();
    }

    @FXML
    void showClasses(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clases");
        alert.setHeaderText("Clases");
        alert.setContentText("Caballero: Vitalidad 10, Fuerza 14, Destreza 7, Magia 3\n" +
                "Ladrón: Vitalidad 8, Fuerza 7, Destreza 16, Magia 3\n" +
                "Mago: Vitalidad 7, Fuerza 8, Destreza 5, Magia 14\n" +
                "Guerrero: Vitalidad 14, Fuerza 14, Destreza 3, Magia 3\n" +
                "Marginado: Vitalidad 9, Fuerza 9, Destreza 9, Magia 9");
        alert.showAndWait();
    }
}
