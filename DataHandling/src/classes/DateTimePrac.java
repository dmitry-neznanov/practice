package classes;

import utilz.Scanner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.InputMismatchException;
import java.util.Locale;

public class DateTimePrac {
    public static void whatsMonth() {
        System.out.println("Введите номер месяца");
        try {
            Month month = Month.of(Scanner.getInputInteger());
            System.out.println("Это месяц " + month.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()));

        } catch (DateTimeException e) {
            System.out.println("Требуется число от 1-12 :3");
            whatsMonth();
        } catch (InputMismatchException e) {
            System.out.println("Это не номер ><");
            whatsMonth();
        }
    }

    public static void findFridays() {
        System.out.println("Введите год");
        String input = Scanner.getInputString();

        if (input.matches("\\d{4}")) {
            int year = Integer.parseInt(input);

            for (int month = 1; month <= 12; month++) {
                LocalDate date = LocalDate.of(year, month, 13);

                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM- EEEE");
                    System.out.println(pattern.format(date));
                }
            }
        } else {
            System.out.println("Введите 4х значное число");
            findFridays();
        }
    }

    public static void findLastDayOfMonth() {
        System.out.println("Введите дату в формате dd.MM.yyyy от 1900 до 2999 года");
        String input = Scanner.getInputString();

        if (input.matches("(?:0?[1-9]|[12][0-9]|3[01])\\.(?:0?[1-9]|1[0-2])\\.(?:19[0-9][0-9]|2[0-9][0-9][0-9])")) {

            Locale locale = Locale.forLanguageTag("en-EN");
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter resultPattern = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy").withLocale(locale);
            LocalDate date = LocalDate.parse(input, pattern);

            System.out.println("Последний день месяца введенной даты это: " + resultPattern.format(date.with(TemporalAdjusters.lastDayOfMonth())));
        } else {
            System.out.println("Дата введена некорректно");
            findLastDayOfMonth();
        }
    }

    public static void theMostFarDate() {
        String[] dates = {
                "11.02.2024 12:00",
                "15.06.2024 11:47",
                "17.06.2024 15:14",
                "18.06.2024 01:48",
                "02.06.2024 19:28",
                "09.07.2024 20:37",
                "24.07.2024 11:56",
                "16.07.2024 17:25",
                "30.07.2024 18:44",
        };

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime currentDate = LocalDateTime.now();

        LocalDateTime mostDistantDate = null;
        long maxDuration = 0;

        for (String dateString : dates) {
            LocalDateTime otherDate = LocalDateTime.parse(dateString, pattern);
            long duration = Duration.between(currentDate, otherDate).abs().toMillis();

            if (duration > maxDuration) {
                mostDistantDate = otherDate;
                maxDuration = duration;
            }
        }
        if (mostDistantDate != null) {
            System.out.println("Самая отдаленная дата: " + mostDistantDate.format(pattern));
        } else {
            System.out.println("Удаленных дат нет");
        }

    }

    public static void timeTillMidnight() {
        System.out.println("Введите время в форме HH:mm");
        String input = Scanner.getInputString();

        if (input.matches("\\b(?:[01][0-9]|2[0-3]):[0-5][0-9]\\b")) {
            LocalDateTime inputTime = LocalDateTime.now().with(LocalTime.parse(input));
            LocalDateTime midnight = LocalDateTime.now().plusDays(1).with(LocalTime.MIDNIGHT);

            long result = ChronoUnit.HOURS.between(inputTime, midnight);

            System.out.printf("%d часов до полуночи", result);
        } else {
            System.out.println("Непрвильный формат");
            timeTillMidnight();
        }
    }
}


































