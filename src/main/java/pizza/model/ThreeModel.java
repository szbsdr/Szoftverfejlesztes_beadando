package pizza.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pizza.controller.PizzaController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThreeModel {

    @FXML
    private void switchScene_last(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/second.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }


    @FXML
    private void finish(ActionEvent event)throws IOException{
        var objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        var order = new PizzaController();
        //order.setTitle("Új rendelés");

        System.out.println(objectMapper.writeValueAsString(order));

        var s = objectMapper.writeValueAsString(order);
        /*System.out.println(s);
        System.out.println(objectMapper.readValue(s, PizzaController.class));*/

        try (var writer = new FileWriter("order.json")) {
            objectMapper.writeValue(writer, order);
        }
        System.out.println(objectMapper.readValue(new FileReader("order.json"), PizzaController.class));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/four.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }





}
