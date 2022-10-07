package javaPractice;

import java.util.Scanner;

public class PrimeNo {
    public static void main(String[] args) {
        String flag;
        do {
            Scanner scanner = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter the number to be checKed");
            int num = scanner.nextInt();
            if (checkPrime(num)) {
                System.out.println("yes " + num + " is prime number");
            } else {
                System.out.println("No " + num + " is not prime number");
            }
            System.out.println("Do you want to checK another number y/n");
            flag=scanner2.nextLine();
        }while (flag.contains("y")||flag.contains("Y"));
    }

    static Boolean checkPrime(int no) {
        boolean flag=true;
        if (no == 0 || no == 1) {
            flag=false;
        }else {
            for (int i = 2; i < no; i++) {
                if (no % i == 0) {
                    flag=false;
//                    System.out.println("No is divisible by = " + i);
                    break;
                }
            }
        }
        return flag;
    }
}
