package javaPractice;

import java.util.*;
import java.util.stream.Collectors;


public class FindDuplicateInArray {
    public static void main(String[] args) {

        int[] array = {2, 3, 5, 6, 7, 8, 5, 3, 5, 7, 4, 3, 6, 6, 0, 63, 1, 3, 4, 8, 9, 9};
        HashMap<Integer, Integer> duplicateList = new HashMap<>();
        System.out.println("Existing array ->"+ Arrays.toString(array));
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
        HashSet<Integer> hashSet= new HashSet<>();
        for (int a :
                array) {
            hashSet.add(a);
        }
        System.out.println("hashSet = " + hashSet);
    }
}
