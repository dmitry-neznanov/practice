package JdbcPractice;

import java.sql.*;

public class DatabaseKit {
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String DB_NAME = "vepamke";
    private final static String ROOT = "root";
    private final static String PASSWORD = "pass";

    public final static String USERS_TABLE = "Users (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(20) NOT NULL, surname VARCHAR(20) NOT NULL, birthdate DATE, PRIMARY KEY (id))";
    public final static String FRIENDSHIPS_TABLE = "friendships (userid1 INT NOT NULL, userid2 INT NOT NULL, timestamp TIMESTAMP)";
    public final static String POSTS_TABLE = "Posts (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, userid INT NOT NULL, timestamp TIMESTAMP)";
    public final static String LIKES_TABLE = "Likes (postid INT NOT NULL, userid INT NOT NULL, timestamp TIMESTAMP)";

    public final static String CUSTOMERS_TABLE = "customer (customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), age INT, city INT)";
    public final static String CITIES_TABLE = "city (city_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, city_name VARCHAR(30), FOREIGN KEY(city_id) REFERENCES customer(customer_id))";

    public static void createTable(String tableDetails) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableDetails;

        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void deleteTable(String tableName) {
        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS " + tableName);

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void search() {
        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE name = ? AND surname = ?");
            preparedStatement.setString(1, "Татьяна");
            preparedStatement.setString(2, "Борисова");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getRow());
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void joinResult() {
        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer.name, city.city_name FROM customer LEFT JOIN city ON customer.city = city.city_id");
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " --- " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, ROOT, PASSWORD);
    }
}
