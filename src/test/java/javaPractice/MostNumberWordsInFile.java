package javaPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MostNumberWordsInFile {
    public static void main(String[] args) throws IOException {
//        Scanner scanner=new Scanner(System.in);
//        String fileName=scanner.next();
//
//        File newFile=new File(System.getProperty("user.dir")+"/src/test/resources/"+fileName+".txt");
//        System.out.println(newFile.getAbsolutePath());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/test.txt"));
        String str = bufferedReader.readLine();
        String[] splitStr = str.split(" ");
        int count = 0;
        String maxWord = "";

        for (String s : splitStr) {
            int iterator = 0;
            for (String s2 :splitStr) {
                if (s.equals(s2) && !maxWord.equals(s)) {
                    iterator++;
                }
            }
            if (count < iterator) {
                count = iterator;
                maxWord = s;
            } else if (count == iterator ) {
                maxWord="-1";}
        }
        if (!maxWord.equals("-1"))
            System.out.println("maxWord = " + maxWord + " and count is " + count);
        else
            System.out.println(maxWord);

    }
}
