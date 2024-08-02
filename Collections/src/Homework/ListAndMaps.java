package Homework;

import Utils.Generator;
import Utils.Scanner;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ListAndMaps {

    // 1.  Сгенерируйте список из целых чисел от 1 до Х включительно

    public static void listGenerator() {
        System.out.println("Введите размер листа");

        int amount = Scanner.getInputInteger();

        if (amount > 0) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < amount; i++) {
                list.add(i + 1);
            }
            list.forEach(System.out::println);

        } else {
            System.out.println("Число в неправильном диапазоне.Попробуйте еще раз");
        }
    }

    // 2.  Удалите дубликаты из коллекции. Arraylist и set

    public static void deleteDuplication() {

        List<Integer> list = Generator.genList(30);

        for (Integer val : list) {
            System.out.print(val + " ");
        }

        Set<Integer> set = new HashSet<>(list);

        System.out.println();
        for (Integer val : set) {
            System.out.print(val + " ");
        }
    }

    // 3.  Создайте новый список, используя только элементы, стоящие на нечетных позициях оригинального списка.

    public static void listOfUneven() {

        List<Integer> list = Generator.genList(20);

        for (Integer val : list) {
            System.out.print(val + " ");
        }

        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                list2.add(list.get(i));
            }
        }
        System.out.println();
        for (Integer val : list2) {
            System.out.print(val + " ");
        }

        // 4.  В списке строк подсчитайте строки, состоящие только из уникальных символов, игнорируя пустые строки.
    }

    public static void amountUniqueStrings() {
        List<String> list = Arrays.asList(
                "здесь", "идет", "какой то", "текст", " ", "для ",
                "примера", "", "работы", "метода", " ");

        list.forEach(System.out::println);

        int count = 0;
        for (String str : list) {
            if (str.strip().matches("[А-Яа-я-A-Za-z]+")) {

                char[] charArray = str.toCharArray();
                Set<Character> set = new HashSet<>();

                for (char xxx : charArray) {
                    set.add(xxx);
                }

                if (set.size() == charArray.length) {
                    count++;
                }
            }
        }
        System.out.printf("Количество уникальных строк %d", count);
    }

    // 5.  Отсортируйте список строк по длине по убыванию. Пузырьковая сортировка

    public static void sortListByLength() {

        List<String> list = new ArrayList<>
                (List.of("здесь", "идет", "какой то", "текст", " ", "для ",
                        "примера", "", "работы", "метода", " "));


        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).length() < list.get(i - 1).length()) {
                    String temp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                    sorted = false;
                }
            }
        }
        list.forEach(System.out::println);
    }

    // 6.  Проверьте что в списке чисел нет отрицательных значений

    public static void checkNegativeNums() {
        List<Integer> list = Generator.genNegativeList(10);

        list.forEach(i -> System.out.print(i + " "));
        System.out.println();

        boolean hasNegative = false;

        for (Integer i : list) {
            if (i < 0) {
                hasNegative = true;
                break;
            }
        }

        if (hasNegative) {
            System.out.println("В списке есть отрицательные числа");
        } else {
            System.out.println("В списке нет отрицательных чисел");
        }
    }

    // 7.   Сгенерируйте Map<Month, Integer>, в которой ключами будут элементы
    // перечисления java.time.Month, а значениями — длина названия этого месяца.
    // То есть результат должен быть такой: {MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ...

    public static HashMap<Month, Integer> monthMap() {
        HashMap<Month, Integer> months = new HashMap<>();

        for (int i = 1; i < Month.values().length + 1; i++) {
            months.put(Month.of(i), Month.of(i).toString().length());
        }
        return months;
    }

    // 8.  Создайте новую Map из исходной так, чтобы ключи и значения поменялись местами.
    // При наличии одинаковых значений в исходной Map необходимо выбросить исключение IllegalArgumentException
    // с описанием проблемы и дублирующегося ключа.

    public static void changedMonthMap() {
        HashMap<Month, Integer> monthMap = ListAndMaps.monthMap();
        HashMap<Integer, Month> newMonthMap = new HashMap<>();

        for (int i = 1; i < monthMap.size(); i++) {
            Month key = null;
            Integer value = monthMap.get(Month.of(i));

            for (Map.Entry<Month, Integer> map : monthMap.entrySet()) {
                if (map.getValue().equals(value)) {
                    key = map.getKey();
                    break;
                }

            }

            try {
                if (!newMonthMap.containsKey(value)) {
                    newMonthMap.put(value, key);
                } else {
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Дублируется ключ - " + value);
            }
        }

        System.out.println(monthMap);
        System.out.println(newMonthMap);

    }

    //9.  Трансформируйте List<Map<String, String>> в список всех значений,
    // которые используются в этих Map, сортировать по длине, затем по алфавиту.

    public static void sortMapsList() {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<>();
        List<String> valuesList = new ArrayList<>();

        for (int i = 1; i < Month.values().length + 1; i++) {
            map1.put(Integer.toString(i), Month.of(i).toString());
        }
        for (int i = 1; i < DayOfWeek.values().length + 1; i++) {
            map2.put(Integer.toString(i), DayOfWeek.of(i).toString());
        }

        list.add(map1);
        list.add(map2);

        for (Map<String, String> i : list) {
            valuesList.addAll(i.values());
        }

        System.out.println("Без сортировки " + valuesList);

        valuesList.sort(Comparator.comparingInt(String::length));
        System.out.println("Отсортировано по длине " + valuesList);

        Collections.sort(valuesList);
        System.out.println("Потом отсортировано по алфавиту " + valuesList);

    }
}






















