package javaPractice;

public class stringPractice {
    public static void main(String[] args) {
//Notes:
//1. to split with . (dot) char in java we need to use [] brasses like slit("[.]")
//2. Concat 2 string with str1+str2 operator or str1.concat(str2) method
//3. To check if string starts with word or letter use startsWith("") method
//4. To print given array use .toString() method (if you use only variable then it prints memory address
//5. To sort given array use Arrays.sort(array_name) method

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

        //insert a word in the middle of the another string.
        String main_string = "Python 3.0";
        String word = "Tutorial";
        System.out.println(main_string.substring(0, 7) + word + main_string.substring(6));
    }
}
