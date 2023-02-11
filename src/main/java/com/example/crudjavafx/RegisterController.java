package com.example.crudjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private void register() throws SQLException {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String direccion = txtDireccion.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        User user = null;
        ResultSet rs = null;

        if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlertInfo(null, "Faltan campos por rellenar");
            return;
        }

        if (DatabaseConnection.execute("SELECT * FROM usuarios WHERE `User` = '" + userName + "'").isBeforeFirst()) {
            showAlertInfo(null, "El usuario ya existe");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlertInfo(null, "Las contraseñas no coinciden");
            return;
        }

        DatabaseConnection.execute("INSERT INTO usuarios (Name, Surname, Direction, User, Password) " +
                "VALUES ('" + nombre + "', '" + apellido + "', '" + direccion + "', '" + userName + "', '" + password + "')");

        showAlertInfo(null, "Usuario registrado correctamente");
    }

    void showAlertInfo(ActionEvent event, String showText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Registration");
        alert.setTitle("Alert!!!");
        alert.setContentText(showText);
        alert.showAndWait();
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void goLogin(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LogIn");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clear(ActionEvent event) {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
    }
}
