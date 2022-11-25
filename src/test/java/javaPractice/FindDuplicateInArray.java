package javaPractice;

import org.junit.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FindDuplicateInArray {
    public static void main(String[] args) {

        int[] array = new int[]{2, 3, 5, 6, 7, 8, 5, 3, 5, 7, 4, 3, 6, 6, 0, 63, 1, 3, 4, 8, 9, 9};

        //using hashmap
        HashMap<Integer, Integer> duplicateList = new HashMap<>();
        System.out.println("Existing array ->" + Arrays.toString(array));
        for (int k : array) {
            int tmp = 0;
            if (!duplicateList.containsKey(k)) {
                for (int j = 1; j < array.length; j++) {
                    if (k == array[j])
                        tmp++;
                }
                if (tmp > 1)
                    duplicateList.putIfAbsent(k, tmp);
            }
        }
        System.out.println("duplicateList = " + duplicateList);

        System.out.println("remove duplicates using set -");
        HashSet<Integer> hashSet = new HashSet<>();
        for (int a : array) hashSet.add(a);
        System.out.println("hashSet = " + hashSet);

        //other easy way
        System.out.println("remove duplicates using list and set ->");
        Set<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toSet());
        System.out.println("hashSet2 = " + list);

//using another array
        System.out.println("Remove duplicate list using another array");
        int[] newArray = new int[array.length];
        int i = 0;
        boolean flag;
        for (int a : array) {
            flag=false;
            for (int b : newArray) {
                if (a == b) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                newArray[i] = a;
                i++;
            }
        }
        Arrays.sort(newArray,0,i+1);
        System.out.println(Arrays.toString(newArray));
        int[] array2=Arrays.copyOfRange(newArray,0,i+1);
        System.out.println(Arrays.toString(array2));
    }
}
