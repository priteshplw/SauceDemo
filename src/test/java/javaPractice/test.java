package javaPractice;

import java.util.ArrayList;
import java.util.List;

public class test {
    static int i = 1;
    public static void main(String[] args) {
//        Double d1=10.0/0.0;
//        System.out.println(d1.isInfinite());
//        double no=5;
//        int expo=3;
//
//        System.out.println(getExpo(no,expo));

        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(0);
        list1.add(-1);
        list1.add(-1);
        double pCount=0,nCount=0,zCount=0;

        for (Integer integer:list1) {
            if (integer.compareTo(0) > 0) {
                pCount++;
            } else if (integer < 0) {
                nCount++;
            } else {
                zCount++;
            }
        }
        list1.stream().forEach(System.out::println);
        System.out.println(pCount!=0?(pCount/list1.size()):"Error");
        System.out.println(nCount!=0?(nCount/list1.size()):"Error");
        System.out.println(zCount!=0?(zCount/list1.size()):"Error");
    }
    public static double getExpo(double no,int expo)
    {
        if(expo>0) {
            no=no*getExpo(no,expo-1);
            System.out.println("loop run times: and expo " + i + "-expo" + expo +" -No" +no);
            i++;
//            return no;
        }
        else{
            System.out.println("Else loop run times: and expo " + i + "-expo" + expo +" -No" +no);
        }
        return no;
    }
}
