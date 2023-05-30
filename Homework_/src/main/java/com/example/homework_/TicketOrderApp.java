package com.example.homework_;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicketOrderApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ticket Order App");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);


        Label userIdLabel = new Label("ID пользователя:");
        GridPane.setConstraints(userIdLabel, 0, 0);

        Label departureLabel = new Label("Время отправлeния:");
        GridPane.setConstraints(departureLabel, 0, 1);

        Label arrivalLabel = new Label("Время прибытия:");
        GridPane.setConstraints(arrivalLabel, 0, 2);

        Label priceLabel = new Label("Цена:");
        GridPane.setConstraints(priceLabel, 0, 3);

        TextField userIdTextField = new TextField();
        GridPane.setConstraints(userIdTextField, 1, 0);

        TextField departureTextField = new TextField();
        GridPane.setConstraints(departureTextField, 1, 1);

        TextField arrivalTextField = new TextField();
        GridPane.setConstraints(arrivalTextField, 1, 2);

        TextField priceTextField = new TextField();
        GridPane.setConstraints(priceTextField, 1, 3);


        Button submitButton = new Button("Подтвердить");
        GridPane.setConstraints(submitButton, 1, 4);
        submitButton.setOnAction(e -> {
            String userId = userIdTextField.getText();
            String departure = departureTextField.getText();
            String arrival = arrivalTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());

            Ticket ticket = new Ticket(userId, departure, arrival, price);
            showTicketDetails(ticket);
        });


        Button newOrderButton = new Button("Новый заказ:");
        GridPane.setConstraints(newOrderButton, 1, 5);
        newOrderButton.setOnAction(e -> {
            userIdTextField.clear();
            departureTextField.clear();
            arrivalTextField.clear();
            priceTextField.clear();
        });

        gridPane.getChildren().addAll(
                userIdLabel, userIdTextField,
                departureLabel, departureTextField,
                arrivalLabel, arrivalTextField,
                priceLabel, priceTextField,
                submitButton, newOrderButton
        );

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showTicketDetails(Ticket ticket) {
        System.out.println("ID пользователя: " + ticket.getUserId());
        System.out.println("Время отправлeния: " + ticket.getDeparture());
        System.out.println("Время прибытия: " + ticket.getArrival());
        System.out.println("Цена: " + ticket.getPrice());
    }

    public static class Ticket {
        private String userId;
        private String departure;
        private String arrival;
        private double price;

        public Ticket(String userId, String departure, String arrival, double price) {
            this.userId = userId;
            this.departure = departure;
            this.arrival = arrival;
            this.price = price;
        }

        public String getUserId() {
            return userId;
        }

        public String getDeparture() {
            return departure;
        }

        public String getArrival() {
            return arrival;
        }

        public double getPrice() {
            return price;
        }
    }
}
