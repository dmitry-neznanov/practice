package JdbcPractice;

import java.sql.*;
import java.util.Random;

public class DatabaseSet {
    public final static String URL = "jdbc:mysql://localhost:3306/";
    public final static String DB_NAME = "vepamke";
    public final static String ROOT = "root";
    public final static String PASSWORD = "pass";


    public static void fillTableUsers() {
        String sql = "INSERT INTO Users (name, surname, birthdate) VALUES (?, ?, ?)";

        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 1000; i++) {
                if (new Random().nextBoolean()) {
                    preparedStatement.setString(1, DataGenerator.genMaleName());
                    preparedStatement.setString(2, DataGenerator.genMaleSurname());
                } else {
                    preparedStatement.setString(1, DataGenerator.genFemaleName());
                    preparedStatement.setString(2, DataGenerator.genFemaleSurname());
                }

                preparedStatement.setDate(3, Date.valueOf(DataGenerator.genDate()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void fillTableFriendships() {
        String sql = "INSERT INTO friendships (userid1, userid2, timestamp) VALUES (?, ?, ?)";

        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 70000; i++) {
                preparedStatement.setInt(1, DataGenerator.genId());
                preparedStatement.setInt(2, DataGenerator.genId());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(DataGenerator.genDateTime()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void fillTablePosts() {
        String sql = "INSERT INTO posts (userid, timestamp) VALUES (?, ?)";

        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 10000; i++) {
                preparedStatement.setInt(1, DataGenerator.genId());
                preparedStatement.setTimestamp(2, Timestamp.valueOf(DataGenerator.genDateTime()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void moveTo() {
        String sql = "INSERT INTO likes (postid, userid, timestamp) VALUES (?, ?, ?)";

        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM posts", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = preparedStatement.executeQuery();


            for (int i = 0; i < 300000; i++) {
                resultSet.absolute(DataGenerator.genRowNumber(10000));
                preparedStatement2.setInt(1, resultSet.getInt(1));
                preparedStatement2.setInt(2, resultSet.getInt(2));
                preparedStatement2.setTimestamp(3, Timestamp.valueOf(DataGenerator.genDateTime()));
                preparedStatement2.executeUpdate();
            }

            System.out.println("Операция выполнена ^^");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void fillTableCustomer() {
        String sql = "INSERT INTO customer (name, age, city) VALUES (?, ?, ?)";
        String[] names = {"Сергей Борисов", "Евгений Петров", "Николай Родионов", "Александр Кабанов", "Мария Нестерова", "Светлана Рябова", "Катерина Голубева", "Александра Смирнова", "Михаил Аксенов", "Андрей Иванов", "Владимир Стрелков", "Максим Одинцов"};

        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (String name : names) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, DataGenerator.genAge());
                preparedStatement.setInt(3, DataGenerator.genCityNumber());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }

    public static void fillTableCity() {
        String sql = "INSERT INTO city (city_name) VALUES (?)";
        String[] cities = {"Москва", "Санкт-петербург", "Новгород", "Рязань", "Казань", "Краснодар", "Екатеринбург", "Тверь", "Сочи", "Киев"};

        try (Connection connection = getConnection()) {
            System.out.println("Подключение к базе данных успешно установлено!");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (String city : cities) {
                preparedStatement.setString(1, city);
                preparedStatement.executeUpdate();
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
