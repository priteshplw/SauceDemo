package javaPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapCollectionTest {

    public static void main(String[] args) {

        //test codes
        //       HashSet<Integer> hashSet=new HashSet<>();
        //       Iterator<Integer> iterator = hashSet.iterator();
        //     iterator.next();
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "pritesh");
        hashMap.put(2, "paliwal");
        hashMap.put(3, "yes");
        hashMap.put(4, "high package");
        hashMap.put(5, "tuples");

        //Method 1
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mp = (Map.Entry) iterator.next();
            System.out.println(mp.getKey());
            System.out.println(mp.getValue());
        }
        //Shorthand method- 2
        for (Map.Entry<Integer, String> integerStringEntry : hashMap.entrySet()) {
            System.out.print("\nKey - " + integerStringEntry.getKey());
            System.out.print(" Value - " + integerStringEntry.getValue());
        }
    }
}