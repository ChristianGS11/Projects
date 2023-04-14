import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class HibernateUtil {
    private static final String URL = "jdbc:postgresql://172.21.9.170:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            Properties properties = new Properties();
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            properties.setProperty("hibernate.connection.url", URL);
            properties.setProperty("hibernate.connection.username", USER);
            properties.setProperty("hibernate.connection.password", PASSWORD);
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.format_sql", "true");

            entityManagerFactory = Persistence.createEntityManagerFactory("meu-banco", properties);
        }
        return entityManagerFactory;
    }
}

