package pageFactory;

import com.util.DriverFactory;
import com.util.DriverUtil;
import com.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    DriverFactory driverFactory=new DriverFactory();
    private WebDriver driver=driverFactory.getDriver();
    private DriverUtil driverUtil=new DriverUtil(driver);
    private ElementUtil elementUtil=new ElementUtil(driver);

    private By headingText;
    private By peekRobotImage;
    private By filterDropdown;
    private By productTitles;
    private By productImages;
    private By productPrices;
    private By addToCartButtons;

    public InventoryPage(){
        headingText=By.className("title");
        peekRobotImage=By.className("peek");
        //Select class should be used for the filter dropdown
        filterDropdown=By.tagName("select");
        productTitles=By.cssSelector("div[class*='item_name']");
        productImages=By.cssSelector("div[class*='item_img']");
        productPrices=By.cssSelector("div[class*='item_price']");
        addToCartButtons=By.cssSelector("button.btn_inventory");
    }


    public String getCurrentURL() {
       return driverUtil.getCurrentURL();
    }

    public String getHeadingText() {
        return elementUtil.getText(headingText);
    }

    public int getTotalProductsCount() {
        return driverUtil.findElements(productTitles).size();
    }
}
