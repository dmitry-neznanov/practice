import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();

        System.out.println("Укажите путь:");

        File dir = new File(new Scanner(System.in).nextLine());

        if (dir.exists()) {
            System.out.println("Номер операции:");

            diskAnalyzer.run(dir, new Scanner(System.in).nextInt());

            DiskAnalyzer.read("DiskAnalyzerResult.txt");
        } else {
            System.out.println("Пути не существует");
        }
    }
}
