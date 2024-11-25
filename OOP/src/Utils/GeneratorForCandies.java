package Utils;

public class GeneratorForCandies {
    public static int[] getNumberArray(){
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 20 - 10);
        }
        return nums;
    }
    public static int genWeight(){
        return (int) (Math.random() * 80 + 20);
    }
    public static int genPrice(){
        return (int) (Math.random() * 200 + 100 );
    }
}
