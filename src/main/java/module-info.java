module com.example.emailsender {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;

    requires org.controlsfx.controls;

    opens com.example.emailsender to javafx.fxml;
    exports com.example.emailsender;
}