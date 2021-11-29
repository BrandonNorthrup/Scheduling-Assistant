/*
Brandon Northrup
Student ID #001177877
Software II - Java - C195
*/

package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import models.Appointment;
import models.Customer;
import models.DatabaseAppointment;
import models.DatabaseCustomer;


public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public void handleCustomerButton() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/views/Customer.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Customer error: " + e.getMessage());
        }
    }
    
    @FXML
    public void handleAppointmentButton() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/views/Appointment.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Appointment error: " + e.getMessage());
        }
    }
    
    @FXML
    public void handleReportsButton() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/views/Report.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Report error: " + e.getMessage());
        }
    }
    
    @FXML
    public void handleLogsButton() {
        File file = new File("log.txt");
        if(file.exists()) {
            if(Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    System.out.println("Error opening log file: " + e.getMessage());
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Appointment appointment = DatabaseAppointment.appointmentIn15Min();
        if(appointment != null) {
            Customer customer = DatabaseCustomer.getCustomer(appointment.getAptCustId());
            String text = String.format("You have a %s appointment with %s at %s.",
                appointment.getAptDescription(), 
                customer.getCustomerName(),
                appointment.get15Time());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointment Reminder");
            alert.setHeaderText("Appointment in 15 minutes!");
            alert.setContentText(text);
            alert.showAndWait();
        }
    }    
}