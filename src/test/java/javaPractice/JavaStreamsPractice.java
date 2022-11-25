package javaPractice;

import com.google.common.math.LinearTransformation;
import com.util.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreamsPractice {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 6};
        int[] array2 = {2, 5, 7, 8};
        String[] s1 = {"cat", "flag", "country","green", "w3resource"};
        String[] s2 = {"cat", "dog", "red", "is", "am"};

        //Merge two arrays, sort and print unique elements using streams
        //Note: Arrays.sort(array); easy method for single array sorting
        IntStream intStream = IntStream.concat(Arrays.stream(array), Arrays.stream(array2));
        intStream.sorted().distinct().forEach(System.out::println);

        //Count unique element from two arrays unique elements
        IntStream intStream2 = IntStream.concat(Arrays.stream(array), Arrays.stream(array2));
        long count = intStream2.distinct().count();
        System.out.println("count = " + count);

        //Print the smallest string within array to console
        System.out.println(Arrays.stream(s2)
                .reduce(" ",((s, s3) -> s.length()>=s3.length()?s:s3)));
        System.out.println(Arrays.stream(s1)
                .reduce(" ",((s, s3) -> s.length()>=s3.length()?s:s3)));

        //Convert Array to array list/set using streams
        List<Integer>  list= Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println("Int Array -> List = " + list);
        Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());
        System.out.println("Int Array -> Set  = " + set);

    }
    @Test
    public void testStreamOnWebElementList(){
        DriverFactory driverFactory=new DriverFactory();
        driverFactory.init_driver("chrome");
        WebDriver driver= driverFactory.getDriver();
        driver.get("https://demo.guru99.com/test/selenium-xpath.html");
        List<WebElement> elementList=driver.findElements(By.xpath("(//b[contains(text(),'Testing')]/parent::h4/following-sibling::ul)[1] //a"));
        List<WebElement> newList=elementList.stream().filter(s->s.getText().contains("Testing")).collect(Collectors.toList());
        for (WebElement e :
                newList) {
            System.out.println("e.getText() = " + e.getText());
        }
        driver.quit();
    }
}
