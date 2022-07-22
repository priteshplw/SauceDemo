package pageFactory;

import com.util.DriverFactory;
import com.util.DriverUtil;
import com.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class GlobalPageObj {
    DriverFactory driverFactory=new DriverFactory();
    private WebDriver driver=driverFactory.getDriver();
    private DriverUtil driverUtil=new DriverUtil(driver);
    private ElementUtil elementUtil=new ElementUtil(driver);

    private By swagLogo;
    private By cartLogo;
    private By navMenu;
    private By twitterLogo;
    private By facebookLogo;
    private By linkedInLogo;
    private By footerRobotImage;
    private By footerCopyRightText;
    private By cartCount;
    private By countSocialLogos;

    public GlobalPageObj(){
        swagLogo=By.className("app_logo");
        cartLogo=By.cssSelector(".shopping_cart_link");
        cartCount=By.cssSelector(".shopping_cart_link span");
        navMenu=By.xpath("//button[text()='Open Menu']");
        twitterLogo=By.cssSelector(".footer a[href*='twitter']");
        facebookLogo=By.cssSelector(".footer a[href*='facebook']");
        linkedInLogo=By.cssSelector(".footer a[href*='linkedin']");
        footerRobotImage=By.cssSelector(".footer img");
        footerCopyRightText=By.cssSelector(".footer div[class='footer_copy']");
        countSocialLogos=By.cssSelector(".social a");
    }

    public Boolean isSwagLogoPresent(){
        return elementUtil.isDisplayed(swagLogo);
    }
    public Boolean isCartIconPresent(){
        return elementUtil.isDisplayed(cartLogo);
    }public void  clickCartIcon(){
        elementUtil.click(cartLogo);
    }
    public Boolean isMenuPresent(){
        return elementUtil.isDisplayed(navMenu);
    }public void  clickOnNavMenu(){
        elementUtil.click(navMenu);
    }
    public Boolean isTwitterIconPresent(){
        return elementUtil.isDisplayed(twitterLogo);
    }public void  clickOnTwitterIcon(){
        elementUtil.click(twitterLogo);
    }

    public Boolean isFacebookIconPresent(){
        return elementUtil.isDisplayed(facebookLogo);
    }public void  clickOnFacebookIcon(){
        elementUtil.click(facebookLogo);
    }

    public Boolean isLinkInIconPresent(){
        return elementUtil.isDisplayed(linkedInLogo);
    }public void  clickOnLinkedInIcon(){
        elementUtil.click(linkedInLogo);
    }

    public String getFooterCopyrightText(){
        return elementUtil.getText(footerCopyRightText);
    }

    public Boolean isFooterRoboPresent(){
        return elementUtil.isDisplayed(footerRobotImage);
    }

    public Boolean isCartCountPresent(){
        return elementUtil.isDisplayed(cartCount);
    }public String getCartCount(){
        return elementUtil.getText(cartCount);
    }

    public int getSocialIconCount(){
        return driverUtil.findElements(countSocialLogos).size();
    }

}
