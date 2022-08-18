package javaPractice;

import java.util.Scanner;

public class SumofDigits {
    public static void main(String[] args) {
        String flag;
        do {
            Scanner scanner = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter the number to be summed");
            int num = scanner.nextInt();
            System.out.println("Sum of Digits of " + num + " is "+sumDigits(num));

            System.out.println("Do you want to checK another number y/n");
            flag = scanner2.nextLine();
        } while (flag.contains("y") || flag.contains("Y"));
    }

    static int sumDigits(int no) {
        int sum = 0;
        do {
            sum=sum+(no%10);
            no=no/10;
        }while (no>0);
        return sum;
    }
}
