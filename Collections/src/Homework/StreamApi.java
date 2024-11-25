package Homework;

import Utils.Generator;
import Utils.Scanner;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {

    // 1.	Сгенерируйте список из целых чисел от 1 до Х включительно.

    public static void listGen() {

        System.out.println("Введите размер листа");

        int amount = Scanner.getInputInteger();

        if (amount > 0) {
            IntStream
                    .range(1, amount + 1)
                    .boxed()
                    .forEach(System.out::println);

        } else {
            System.out.println("Число в неправильном диапазоне.Попробуйте еще раз");
        }
    }

    // 2.	Создайте новый список, используя только элементы, стоящие на нечетных позициях оригинального списка.

    public static void listOfUneven() {
        System.out.println("Введите размер листа");
        int listSize = Scanner.getInputInteger();

        List<Integer> list = Generator.genList(listSize);

        list.forEach(e -> System.out.print(e + " "));
        System.out.println();

        List<Integer> list2 = list.stream().filter(i -> i % 2 != 0).toList();

        list2.forEach(e -> System.out.print(e + " "));

    }

    // 3.	В списке строк подсчитайте строки, состоящие только из уникальных символов, игнорируя пустые строки.


    public static void uniqueStrings() {
        List<String> list = List.of("первая", "вторая", "третья", "четвертая", "пятая", "шестая", "седьмая", "восьмая", "девятая", "десятая");


        list.forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Уникальных строк в листе - " + list.stream()
                .filter(e -> e.chars().distinct().count() == e.length())
                .count());
    }

    // 4.	Отсортируйте список строк по длине по убыванию.

    public static void sortList() {
        List<String> list = List.of("1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789");

        List<String> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);
    }

    // 5.	Проверьте что в списке чисел нет отрицательных значений.

    public static void checkNegativeNumbers() {
        List<Integer> list = Generator.genNegativeList(10);

        list.forEach(i -> System.out.print(i + " "));
        System.out.println();

        boolean b = list.stream().anyMatch(i -> i < 0);

        if (b) {
            System.out.println("В списке есть отрицательные числа");
        } else {
            System.out.println("В списке нет отрицательных чисел");
        }


    }

    // 6.	Сгенерируйте Map<Month, Integer>, в которой ключами будут элементы перечисления java.time.Month,
    // а значениями — длина названия этого месяца. То есть результат должен быть такой: {MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ...

    public static void mapGen() {
        Map<Month, Integer> map = Arrays.stream(Month.values()).
                collect(Collectors.toMap(
                        monthName -> monthName,
                        monthName -> monthName.name().length()
                ));
        System.out.println(map);
    }

    // 7.	Найдите самый частый символ в строке (исключая пробелы).


    public static void mostCommonSymbol() {
        String string = "Хотите узнать, что будет, если взять внучку экстрасенса, неверящую в НЛО, и фаната уфологии, который и думать не желает о призраках?";

        Map.Entry<Character, Long> symb = string.replaceAll(" ", "").chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println("Самый частый символ в строке - " + symb);


    }

    // 8.	Трансформируйте List<Map<String, String>> в список всех значений, которые используются в этих Map, сортировать по длине, затем по алфавиту.


    public static void listToList() {
        Map<String, String> map1 = Arrays.stream(Month.values()).
                collect(Collectors.toMap(
                        Enum::toString,
                        Enum::name
                ));
        Map<String, String> map2 = Arrays.stream(DayOfWeek.values()).
                collect(Collectors.toMap(
                        Enum::toString,
                        Enum::name
                ));


        List<Map<String, String>> oldList = List.of(map1, map2);
        List<String> newList = new ArrayList<>();

        oldList.forEach(i -> newList.addAll(i.values()));

        System.out.println("Без сортировки " + newList);

        newList.sort(Comparator.comparingInt(String::length));
        System.out.println("Отсортировано по длине " + newList);

        Collections.sort(newList);
        System.out.println("Потом отсортировано по алфавиту " + newList);

    }

}
