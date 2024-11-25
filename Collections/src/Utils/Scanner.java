package Utils;

import java.util.InputMismatchException;

public class Scanner {
    public static int getInputInteger() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Требуется число");
                scanner.next();
            }
        }
    }

    public static String getInputString() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }
}
