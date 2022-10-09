package javaPractice;

import java.util.Collections;

public class Test1 {
    public static void main(String[] args) throws NullPointerException {
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        System.out.println("Max element is ->"+max(my_array));
        System.out.println("Max element is ->"+min(my_array));

    }

    static int max(int[] a) {
        int max = 0;
        for (int tmp : a) {
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
    static int min(int[] a) {
        int max = 0;
        for (int tmp : a) {
            if (tmp < max || max==0) {
                max = tmp;
            }
        }
        return max;
    }
}
