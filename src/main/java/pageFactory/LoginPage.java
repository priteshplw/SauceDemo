package pageFactory;

import com.util.DriverFactory;
import com.util.DriverUtil;
import com.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPage {
    DriverFactory driverFactory = new DriverFactory();
    private WebDriver driver = driverFactory.getDriver();
    private ElementUtil elementUtil = new ElementUtil(driver);
    private DriverUtil driverUtil = new DriverUtil(driver);

    private By sauceLogo;
    private By userName;
    private By password;
    private By loginButton;
    private By robotImage;
    private By userNameLabels;
    private By userPasswordLabels;
    private By userNameHeading;
    private By userPasswordHeading;
    private By errorMessage;


    public LoginPage() {
        sauceLogo = By.className("login_logo");
        userName = By.id("user-name");
        password = By.id("password");
        loginButton = By.cssSelector("input[type='submit']");
        robotImage = By.cssSelector(".bot_column");
        userNameHeading = By.cssSelector("div.login_credentials h4");
        userPasswordHeading = By.cssSelector("div.login_password h4");
        userNameLabels = By.cssSelector("div.login_credentials");
        userPasswordLabels = By.cssSelector("div.login_password");
        errorMessage = By.tagName("h3");
    }

    public void navigateToLoginPage() throws NullPointerException {
        driverUtil.get("https://www.saucedemo.com/");
    }

    public String getPageTitle() {
        return driverUtil.getTitle();
    }

    public Boolean isLogoDisplayed() {
        return elementUtil.isDisplayed(sauceLogo);
    }

    public Boolean robotImageDisplayed() {
        return elementUtil.isDisplayed(robotImage);
    }

    public Boolean isUserTextBoxDisplayed() {
        return elementUtil.isDisplayed(userName);
    }

    public Boolean isPassTextBoxDisplayed() {
        return elementUtil.isDisplayed(password);
    }

    public Boolean isLoginButtonDisplayed() {
        return elementUtil.isDisplayed(loginButton);
    }

    public void enterUserName(String uname) {
        elementUtil.sendKeys(userName,uname);
    }

    public void enterPassword(String pass) {
        elementUtil.sendKeys(password,pass);
    }

    public void clickLogin() {
        elementUtil.click(loginButton);
    }

    /* These methods are not required now
    public String getUserNameHeading() {
        return elementUtil.getText(userNameHeading);
    }

    public String getPasswordHeading() {
        return elementUtil.getText(userPasswordHeading);
    }*/
    public String getUserNameLabels() {
        return elementUtil.getText(userNameLabels);
    }

    public String getPasswordLabels() {
        return elementUtil.getText(userPasswordLabels);
    }

    public String getErrorMessage() {
        return elementUtil.getText(errorMessage);
    }
}
