package pizza.model;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jdbi.v3.core.Jdbi;
import pizza.controller.OrderDataController;
import pizza.controller.PizzaController;
import pizza.db.OrderDao;
import pizza.db.PizzaDao;
import pizza.controller.PizzaController;
import pizza.db.DatabaseSetup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PizzaOrderApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/fist.fxml"));
        stage.setTitle("Pizza rendelés");
        stage.setScene(new Scene(root));
        stage.show();
    }
/*
    @Override
    public void init() {
        // Adatbázis kapcsolat
        Jdbi jdbi = DatabaseSetup.setup();

        // példa1
        OrderDataController order = new OrderDataController("John Doe", "123 Main St", "555-1234", "Credit Card");

        // példa2
        PizzaController pizza = new PizzaController();

        // példa3
        pizza.feltetSonka = new CheckBox(); pizza.feltetSonka.setSelected(true);
        pizza.feltetGomba = new CheckBox(); pizza.feltetGomba.setSelected(true);
        pizza.meret32 = new RadioButton(); pizza.meret32.setSelected(true);
        pizza.collectSelectedToppings();

        // Adatok mentése
        jdbi.useHandle(handle -> {
            OrderDao orderDao = handle.attach(OrderDao.class);
            PizzaDao pizzaDao = handle.attach(PizzaDao.class);

            // Rendelési adatok mentése
            long orderId = orderDao.insertOrder(order);

            // Pizza adatok mentése
            for (String topping : pizza.getSelectedToppings()) {
                pizzaDao.insertPizza(orderId, topping, pizza.getSelectedSize());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
*/
}
