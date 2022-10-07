package javaPractice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) throws NullPointerException {
        System.out.println("Enter the string or int ->");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        if (checkPalindrome(a))
            System.out.println("yeah this is the palindrome");

    }


    public static Boolean checkPalindrome(int tmp) {
        int reversed = 0;
        int original = tmp;
        while (tmp % 10 != 0) {
            reversed = (reversed * 10) + (tmp % 10);
            tmp = tmp / 10;
        }
        System.out.println("reversed = " + reversed);
        return reversed == original;
    }

    static Boolean checkPalindrome(String str) throws NullPointerException {

        //Very short way to reverse the string
        //String reversed = new StringBuilder().append(str).reverse().toString();
        String reversed=new StringBuffer(str).reverse().toString();
        System.out.println("reversed = " + reversed);
        //Validate if string is same after reversal
        return reversed.equals(str);
    }
}
