package com.example.crudjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private PasswordField txtEmail;

    @FXML
    private void register() throws SQLException {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String direccion = txtDireccion.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();
        User user = null;
        ResultSet rs = null;

        if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || userName.isEmpty() || password.isEmpty() || email.isEmpty()) {
            showAlertInfo(null, "Faltan campos por rellenar");
            return;
        }

        if (DatabaseConnection.execute("SELECT * FROM usuarios WHERE `User` = '" + userName + "'") == null) {
            showAlertInfo(null, "El usuario ya existe");
            return;
        }

        DatabaseConnection.execute("INSERT INTO usuarios (Nombre, Apellido, Direccion, User, Password, Email) " +
                "VALUES ('" + nombre + "', '" + apellido + "', '" + direccion + "', '" + userName + "', '" + password + "', '" + email + "')");
        //DatabaseConnection.execute("SELECT * FROM usuarios WHERE `User` = '" + userName + "' and `Password` = '" + password + "'") devuelve un result
        //set, pero no se como coger el usuario de ese result set

        rs = DatabaseConnection.execute("SELECT * FROM usuarios WHERE `User` = '" + userName + "' and `Password` = '" + password + "'");
        while (rs.next()) {
            user = new User(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Direccion"), rs.getString("User"), rs.getString("Password"));
        }
        Main.setUser(user);
        showAlertInfo(null, "Usuario registrado correctamente");
    }

    void showAlertInfo(ActionEvent event, String showText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("LogIn");
        alert.setTitle("Alert!!!");
        alert.setContentText(showText);
        alert.showAndWait();
    }

}
