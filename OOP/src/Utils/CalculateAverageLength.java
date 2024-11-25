package Utils;

public class CalculateAverageLength {
    public static double stringLength(String[] strings) {
        int average = 0;
        for (String totalLength : strings) {
            average += totalLength.length();
        }
        return (double) average / strings.length;
    }
}
