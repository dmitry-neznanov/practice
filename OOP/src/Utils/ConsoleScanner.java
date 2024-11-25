package Utils;

import java.util.Scanner;

public class ConsoleScanner {
    public static int getInputInteger(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static String getInputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
