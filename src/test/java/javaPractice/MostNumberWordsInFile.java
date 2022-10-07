package javaPractice;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MostNumberWordsInFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner=new Scanner(System.in);
        String fileName=scanner.next();
        String path=System.getProperty("user.dir")+"/src/test/resources/"+fileName+".txt";

        File newFile=new File(path);
        System.out.println(newFile.getAbsolutePath());
        FileWriter writer=new FileWriter(newFile);
        writer.write("this the test file which is file will be used in identifying word have is large count in this file");
        writer.flush();
        writer.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));
        String str = bufferedReader.readLine();
//        Other Way of capturing data from the file
//        Scanner scanner2=new Scanner(new FileReader(System.getProperty("user.dir") + "/src/test/resources/test.txt"));
//        String str2= scanner2.next();
//        System.out.println("str2 = " + str2);


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

        if (newFile.delete())
            System.out.println("File deleted successfully");
        else
            System.out.println("File not deleted");
    }
}
