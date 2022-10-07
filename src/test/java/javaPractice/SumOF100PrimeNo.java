package javaPractice;

import java.util.ArrayList;
import java.util.List;

public class SumOF100PrimeNo {
    public static void main(String[] args) {
        SumOF100PrimeNo sumOF100PrimeNo = new SumOF100PrimeNo();
        List<Integer> primeList = sumOF100PrimeNo.get100PrimeNos();
        int sum = primeList.stream().reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
    }

    List<Integer> get100PrimeNos() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; list.size() < 100; i++) {
            if (PrimeNo.checkPrime(i)) {
                list.add(i);
            }
        }
        System.out.println("list = " + list);
        return list;
    }
}
