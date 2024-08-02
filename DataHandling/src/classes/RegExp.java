package classes;

import utilz.Scanner;

import java.util.ArrayList;
import java.util.List;

public class RegExp {
    public static void firstLettersTheSame() {
        System.out.println("Ведите имя и фамилию");
        String fullName = Scanner.getInputString();

        if (fullName.matches("(.{1,20}[A-Za-zА-Яа-я]) (.{1,20}[A-Za-zА-Яа-я])")) {
            String[] nameAndSecondName = fullName.split(" ");

            String str = nameAndSecondName[0];
            String str2 = nameAndSecondName[1];

            if (str.charAt(0) == str2.charAt(0)) {
                System.out.println("Имя и фамилия начинаются с одной буквы ^^");
            } else {
                System.out.println("Имя и фамилия начинаются на разные буквы ТТ");
            }
        } else {
            System.out.println("Что то пошло не так(");
            firstLettersTheSame();
        }
    }

    public static void flipWords() {
        String text = "тут какой то текст";

        String[] words = text.split(" ");
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                builder.append(new StringBuilder(words[i]).reverse());
            } else {
                builder.append(new StringBuilder(words[i]).reverse().append(" "));
            }
        }
        System.out.println(builder);
    }

    public static void changeStrings() {
        String string = "lowerCaseName";

        char[] arr = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char symbol : arr) {
            if (Character.isUpperCase(symbol)) {
                sb.append("_").append(symbol);
            } else {
                sb.append(symbol);
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }

    public static void changeString2() {
        String string = "UPPER_CASE_NAME".toLowerCase();
        String[] arr = string.split("_");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1));
            }
        }
        System.out.println(sb);

    }

    public static void namesFinder() {
        String string = "Анна, Маша, Ангелина, Павел, Коля";
        String[] names = string.split(",");

        List<String> result = new ArrayList<>();

        for (String name : names) {
            if (name.strip().matches("А.+?а")) {
                result.add(name);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Подходящих имен нет");
        }
        for (String x : result) {
            System.out.println(x);
        }
    }
}




















