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


    public void btnLoginClicked(ActionEvent actionEvent) {
        String password = txtPassword.getText();
        String login = txtUser.getText();

        try {
            DataExchange.odbiorca = login;
            DataExchange.haslo = password;

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("widokPogram.fxml"));
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