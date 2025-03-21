package JdbcPractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    public static int genId() {
        return (int) (Math.random() * 1000) + 1;
    }

    public static int genAge() {
        return (int) (Math.random() * 30) + 20;
    }

    public static int genRowNumber(int num) {
        return (int) (Math.random() * num) + 1;
    }

    public static int genCityNumber() {
        return (int) (Math.random() * 10) + 1;
    }

    public static int genPostId() {
        return 100000 + (int) (Math.random() * 900000);
    }

    public static String genMaleName() {
        String[] names = {"Сергей", "Евгений", "Николай", "Александр", "Алексей", "Дмитрий", "Павел", "Александра", "Михаил", "Андрей", "Владимир", "Максим"};
        return names[(int) (Math.random() * names.length)];
    }

    public static String genFemaleName() {
        String[] names = {"Светлана", "Мария", "София", "Екатерина", "Виктория", "Татьяна", "Ирина", "Ксения", "Евгения", "Ольга", "Соня"};
        return names[(int) (Math.random() * names.length)];
    }

    public static String genMaleSurname() {
        String[] surnames = {"Борисов", "Иванов", "Петров", "Лазарев", "Аксенов", "Родионов", "Кудряшов", "Кулагин", "Кабанов", "Нестеров", "Юдин", "Савельев", "Одинцов", "Смирнов", "Рябов", "Голубев"};
        return surnames[(int) (Math.random() * surnames.length)];
    }

    public static String genFemaleSurname() {
        String[] surnames = {"Борисова", "Иванова", "Петрова", "Лазарева", "Аксенова", "Родионова", "Кудряшова", "Кулагина", "Кабанова", "Нестерова", "Юдина", "Савельева", "Одинцова", "Смирнова", "Рябова", "Голубева"};
        return surnames[(int) (Math.random() * surnames.length)];
    }

    public static LocalDate genDate() {
        LocalDate startDate = LocalDate.of(2000, 1, 1); // Начальная дата
        LocalDate endDate = LocalDate.of(2025, 12, 31); // Конечная дата

        long randomDays = ThreadLocalRandom.current().nextLong(ChronoUnit.DAYS.between(startDate, endDate));

        return startDate.plusDays(randomDays);
    }

    public static LocalDateTime genDateTime() {
        LocalDateTime startDateTime = LocalDateTime.of(2015, 1, 1, 0, 0, 0); // Начальная дата и время
        LocalDateTime endDateTime = LocalDateTime.of(2015, 12, 31, 23, 59, 59); // Конечная дата и время

        long randomSeconds = ThreadLocalRandom.current().nextLong(ChronoUnit.SECONDS.between(startDateTime, endDateTime));

        return startDateTime.plusSeconds(randomSeconds);
    }
}
