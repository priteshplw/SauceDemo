package javaPractice;

import java.util.Arrays;

public class RotateArrayElements {
    public static void main(String[] args) {
        int[] array = new int[]{20, 30, 40,50};
        System.out.println("Left Rotate ==>");
        rotateInLeftSide(array);
        System.out.println("\nRight Rotate ==>");
        rotateInRightSide(array);
    }
    static void rotateInLeftSide(int[]  array){
        int[] array2 = new int[4];
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                array2[i] = array[0];
            } else {
                array2[i] = array[i + 1];
            }
        }
        System.out.println("array2 = " + Arrays.toString(array2));
//        for (int a : array2) {
//            System.out.print(a+" ");
//        }
    }
    static void rotateInRightSide(int[]  array){
        int[] array2 = new int[4];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array2[i] = array[array.length-1];
            } else {
                array2[i] = array[i - 1];
            }
        }
        for (int a : array2) {
            System.out.print(a+" ");
        }
    }
}
