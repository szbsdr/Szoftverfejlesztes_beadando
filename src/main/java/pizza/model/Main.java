package pizza.model;
import org.jdbi.v3.core.Jdbi;
import pizza.controller.OrderDataController;
import pizza.controller.PizzaController;
import pizza.db.OrderDao;
import pizza.db.PizzaDao;
import pizza.db.DatabaseSetup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

import javafx.application.Application;
import pizza.db.DatabaseSetup;


public class Main {

    public static void main(String[] args) {
        Application.launch(PizzaOrderApplication.class, args);
    }



}
