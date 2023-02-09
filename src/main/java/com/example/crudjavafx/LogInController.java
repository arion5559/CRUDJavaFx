package com.example.crudjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField txtUsuario = new TextField();
    @FXML
    private PasswordField txtPsw = new PasswordField();
    @FXML
    private Button btnEnter = new Button();
    @FXML
    private Button btnRegister = new Button();
    @FXML
    private Button btnExit = new Button();

    @FXML
    void enterLogIn(ActionEvent event) {
        boolean letThrough = false;

        try{
            letThrough = validateLogIn();
        } catch (SQLException e) {
            letThrough = false;
        }

        if (!letThrough){
            showAlertInfo(event, "LogIn incorrecto, prueba de nuevo");
        } else {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void showAlertInfo(ActionEvent event, String showText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("LogIn");
        alert.setTitle("Alert!!!");
        alert.setContentText(showText);
        alert.showAndWait();
    }

    private boolean validateLogIn() throws SQLException {
        String userName = txtUsuario.getText();
        String psw = txtPsw.getText();
        ResultSet rs = null;
        User user = null;
        boolean good = false;

        rs = DatabaseConnection.execute("SELECT * FROM usuarios " +
                "WHERE `User` = '" + userName + "' and `Password` = '" + psw + "'");

        while (rs.next()){
            user = new User(rs.getInt("ID"), rs.getString("Name"), rs.getString("Surname"),
                    rs.getString("Direction"), rs.getString("User"), rs.getString("Password"));
        }

        if ((user.getUsername() == userName) && (user.getPassword() == psw)){
            good = true;
        }

        return good;
    }

    @FXML
    void register(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("register-view.fxml"));
            primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

}
