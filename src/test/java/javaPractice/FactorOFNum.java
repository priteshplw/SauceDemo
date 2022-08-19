package javaPractice;

public class FactorOFNum {
    public static void main(String[] args) {
        System.out.println("Factor count for %d is ->"+new FactorOFNum().numberOfFactors(25));
    }
    public int numberOfFactors(int num){
        int count=0;
        for (int i = 1; i <= num; i++) {
            if (num%i==0)
                count++;
        }
        return count;
    }
}
