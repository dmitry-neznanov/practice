package classes;

import utilz.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StrProc {
    public static void toBinaryToString() {
        System.out.println("Введите положительное число");
        String incomingString = Scanner.getInputString();
        while (!incomingString.matches("\\d+")) {
            System.out.println("Вы ввели неверно");
            incomingString = Scanner.getInputString();
        }
        if (incomingString.matches("\\d+")) {
            String binaryCodeString = Integer.toBinaryString(Integer.parseInt(incomingString));
            System.out.println(binaryCodeString);
        }
    }

    public static void colorChanger() {
        System.out.println("Введите цвет в формате HEX");
        String hexColor = Scanner.getInputString();
        if (hexColor.matches("#(\\w{2})(\\w{2})(\\w{2})")) {
            Pattern pattern = Pattern.compile("#(\\w{2})(\\w{2})(\\w{2})");
            Matcher matcher = pattern.matcher(hexColor);

            if (matcher.find()) {
                int red = Integer.parseInt(matcher.group(1), 16);
                int green = Integer.parseInt(matcher.group(2), 16);
                int blue = Integer.parseInt(matcher.group(3), 16);

                System.out.printf("rgb(%d, %d, %d)", red, green, blue);
            }
        } else {
            System.out.println("Цвет не соответствует ожидаемому формату.");
            colorChanger();
        }
    }

    public static void reverseCase() {
        System.out.println("Введите текст");
        String text = Scanner.getInputString();
        StringBuilder result = new StringBuilder();

        char[] chars = text.toCharArray();
        for (char thisChar : chars) {
            if (Character.isUpperCase(thisChar)) {
                result.append(Character.toLowerCase(thisChar));
            } else if (Character.isLowerCase(thisChar)) {
                result.append(Character.toUpperCase(thisChar));
            } else {
                result.append(thisChar);
            }
        }
        System.out.println(result);
    }

    public static void intArrayToPrint() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,};
        int lineSize = 3;

        for (int i = 0; i < array.length; i++) {
            if (i > 0 && i % lineSize == 0) {
                System.out.println();
            }
            System.out.print(array[i] + ", ");
        }
    }
}
