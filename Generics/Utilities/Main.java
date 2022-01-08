package Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list , 3, 4 ,5 ,1);

        int maxNum = ListUtils.getMax(list);
        System.out.println(maxNum);
    }
}
