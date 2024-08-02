package utilz;

public class Scanner {
    public static int getInputInteger() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getInputString() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }

}
