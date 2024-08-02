package Utils;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<Integer> genList(int size){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add((int)(Math.random() * 30 + 10));
        }
        return list;
    }

    public static List<Integer> genNegativeList(int size){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add((int)(Math.random() * 20 - 5));
        }
        return list;
    }


}
