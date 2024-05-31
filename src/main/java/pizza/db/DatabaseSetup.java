package pizza.db;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Slf4JSqlLogger;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DatabaseSetup {
    public static Jdbi setup() {

        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        jdbi.installPlugin(new SqlObjectPlugin());
        jdbi.setSqlLogger(new Slf4JSqlLogger());


        jdbi.useHandle(handle -> {
            handle.execute("CREATE TABLE orders (" +
                    "id IDENTITY PRIMARY KEY," +
                    "name VARCHAR(100)," +
                    "address VARCHAR(200)," +
                    "phone_number VARCHAR(15)," +
                    "payment_method VARCHAR(50))");

            handle.execute("CREATE TABLE pizzas (" +
                    "id IDENTITY PRIMARY KEY," +
                    "order_id BIGINT," +
                    "topping VARCHAR(50)," +
                    "size VARCHAR(10)," +
                    "FOREIGN KEY (order_id) REFERENCES orders(id))");
        });

        return jdbi;
    }
}