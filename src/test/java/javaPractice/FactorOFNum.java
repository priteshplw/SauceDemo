package javaPractice;

public class FactorOFNum {
    public static void main(String[] args) {
        System.out.println("Factor count for 25 is ->"+numberOfFactors(25));
    }
    public static int numberOfFactors(int num){
        int count=0;
        for (int i = 1; i <= num; i++) {
            if (num%i==0)
                count++;
        }
        return count;
    }
}
