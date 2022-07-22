package stepDefinations.selenium;


import com.util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    pageFactory.LoginPage loginPageObjects = new pageFactory.LoginPage();

    @When("^User enter the valid URL for Swag Lab application$")
    public void User_enter_the_valid_URL_for_Swag_Lab_application() {
        loginPageObjects.navigateToLoginPage();
    }

    @When("User is on the Swag Lab Login or Landing page")
    public void userIsOnTheSwagLabLoginLandingPage() {
        Assert.assertEquals("Swag Labs", loginPageObjects.getPageTitle());
    }

    @Then("Login Page Swag Lab logo visible on the top of the page")
    public void loginPageswagLabLogoVisibleOnTheTopOfThePage() {
        Assert.assertTrue(loginPageObjects.isLogoDisplayed());
    }

    @Then("User should be navigated to the Swag Lab Login or Landing page")
    public void userShouldBeNavigatedToTheSwagLabLoginOrLandingPage() {
        Assert.assertEquals("Swag Labs", loginPageObjects.getPageTitle());
    }

    @And("User Name and Password field should be visible in page")
    public void userNameAndPasswordFieldShouldBeVisibleInPage() {
        Assert.assertTrue(loginPageObjects.isUserTextBoxDisplayed());
        Assert.assertTrue(loginPageObjects.isPassTextBoxDisplayed());
    }

    @And("Login button should be visible in the page")
    public void loginButtonShouldBeVisibleInThePage() {
        Assert.assertTrue(loginPageObjects.isLoginButtonDisplayed());
    }

    @And("Robo picture should be visible in the page")
    public void robotPictureShouldBeVisibleInThePage() {
        Assert.assertTrue(loginPageObjects.robotImageDisplayed());
    }

    @And("Accepted User name labels are visible in the page")
    public void acceptedUserNameLabelsAreVisibleInThePage() {
//        System.out.println(loginPageObjects.getUserNameHeading());
        System.out.println(loginPageObjects.getUserNameLabels());
    }

    @And("Accepted password labels are visible in page")
    public void acceptedPasswordLabelsAreVisibleInPage() {
//        System.out.println(loginPageObjects.getPasswordHeading());
        System.out.println(loginPageObjects.getPasswordLabels());
    }

    @And("User enters the username as {string}")
    public void userEntersTheUsernameAs(String username) {
        loginPageObjects.enterUserName(username);
    }

    @And("User enters the password as {string}")
    public void userEntersThePasswordAs(String password) {
        loginPageObjects.enterPassword(password);
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        WebDriver driver=DriverFactory.tlDriver.get();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl());
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        loginPageObjects.clickLogin();
    }

    @Then("Login should fail and error message is displayed as {string}")
    public void loginShouldFailAndErrorMessageIsDisplayedAs(String arg0) {
        Assert.assertEquals(arg0, loginPageObjects.getErrorMessage());
    }

}