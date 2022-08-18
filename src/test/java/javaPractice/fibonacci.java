package javaPractice;

public class fibonacci {
    static int a=0,b=1;

    public static void main(String[] args) {
        System.out.print("Fibonacci Series -> ");
       series(10);

    }
    static void series(int count){
        if(count>0){
            System.out.print(a+", ");
            int tmp=a+b;
            a=b;
            b=tmp;
            series(--count);
        }else {
            System.out.println("........");
        }
    }
}

