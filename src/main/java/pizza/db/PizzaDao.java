package pizza.db;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import pizza.controller.PizzaController;

@RegisterBeanMapper(PizzaController.class)
public interface PizzaDao {



    @SqlUpdate("INSERT INTO pizzas (order_id, topping, size) VALUES (:orderId, :topping, :size)")
    void insertPizza(long orderId, String topping, String size);
}
