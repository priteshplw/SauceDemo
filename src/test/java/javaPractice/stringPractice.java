package javaPractice;

public class stringPractice {
    public static void main(String[] args) {
        String s="My name is Pritesh.";
//        char[] chars = new char[10];
//        System.out.println("chars = " + chars.length);
        //Reverse String code
        System.out.println("Reverse the string by each character->");
        for (int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
        System.out.println();
        //Reverse String oneliner code
        System.out.println(new StringBuffer(s).reverse());
        System.out.println();

        //Print String word in mentioned order "Pritesh is my name."
        System.out.println("Reverse the string with whole words");
        String tmp=s.replace(".","");

        String[] split=tmp.split(" ");
        System.out.print(split[3]+" ");
        System.out.print(split[2]+" ");
        System.out.print(split[0]+" ");
        System.out.print(split[1]+".");

        System.out.println();
        //Print each word's characters in reversed order "yM eman si hsetirP."
        for (String s1:split) {
            for (int i=s1.length()-1;i>=0;i--)
            System.out.print(s1.charAt(i));
            System.out.print(" ");
        }
        System.out.print(".");
    }
}
