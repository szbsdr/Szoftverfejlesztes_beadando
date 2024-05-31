package pizza.db;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import pizza.controller.OrderDataController;

@RegisterBeanMapper(OrderDataController.class)
public interface OrderDao {


    @SqlUpdate("INSERT INTO orders (name, address, phone_number, payment_method) VALUES (:name, :address, :phoneNumber, :paymentMethod)")
    @GetGeneratedKeys
    long insertOrder(@BindBean OrderDataController order);
}