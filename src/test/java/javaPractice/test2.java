package javaPractice;

public class test2 {
        public static void main(String[] args) {
            String str="My name is Pritesh";
            String[] strArray=str.split(" ");

            for(String s:strArray){
                for(int i=s.length()-1;i>=0;i--){
                    System.out.print(s.charAt(i));
                }
                System.out.print(" ");
            }
        }
}
