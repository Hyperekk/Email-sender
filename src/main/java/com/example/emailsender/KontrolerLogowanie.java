package com.example.emailsender;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class KontrolerLogowanie {
    public Button btnLogin;
    public PasswordField txtPassword;
    public TextField txtUser;

    public static String odbiorca;

    public static String haslo;

    public void btnLoginClicked(ActionEvent actionEvent) {
        String password = txtPassword.getText();
        String login = txtUser.getText();

        try {
            DataExchage.odbiorca = login;
            DataExchage.haslo = password;

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("widokProgram.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Email-Sender");
            stage.setScene(scene);
            stage.show();
            ((Stage) txtPassword.getScene().getWindow()).close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}