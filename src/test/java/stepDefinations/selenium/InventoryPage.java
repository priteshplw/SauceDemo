package stepDefinations.selenium;

import com.util.DriverUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageFactory.GlobalPageObj;

public class InventoryPage {
    private pageFactory.InventoryPage inventoryPage=new pageFactory.InventoryPage();
    private GlobalPageObj globalPageObj=new GlobalPageObj();

    @When("User is on Inventory Page")
    public void userIsOnInventoryPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getCurrentURL());
    }
    @Then("Swag Lab logo should be visible on the top of the page")
    public void swagLabLogoShouldBeVisibleOnTheTopOfThePage() {
        Assert.assertTrue(globalPageObj.isSwagLogoPresent());
    }
    @And("User should see Cart Icon on top right of the page")
    public void userShouldSeeCartIconOnTopRightOfThePage() {
        Assert.assertTrue(globalPageObj.isCartIconPresent());
    }

    @And("User should see Navigation Menu on top left of the page")
    public void userShouldSeeNavigationMenuOnTopLeftOfThePage() {
        Assert.assertTrue(globalPageObj.isMenuPresent());
    }

    @And("User Should see the {string} Title text above product inventory")
    public void userShouldSeeTheTitleTextAboveProductInventory(String arg0) {
        Assert.assertEquals(inventoryPage.getHeadingText(), arg0);
    }

    @And("User should be able to see inventory products in page")
    public void userShouldBeAbleToSeeInventoryProductsInPage() {
        Assert.assertEquals(inventoryPage.getTotalProductsCount(), 6);
    }

    @And("User should see the {int} Social media icons in page footer")
    public void userShouldSeeTheSocialMediaIconsInPageFooter(int arg0) {
        Assert.assertEquals(globalPageObj.getSocialIconCount(),arg0);
    }

    @And("User should see the footer copyright text")
    public void userShouldSeeTheFooterCopyrightText() {
        Assert.assertEquals("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy", globalPageObj.getFooterCopyrightText());
    }

    @And("User should see robo image in right side of footer")
    public void userShouldSeeRoboImageInRightSideOfFooter() {
        Assert.assertTrue(globalPageObj.isFooterRoboPresent());
    }

    @Then("User should be able to see below Product titles and price in the page")
    public void userShouldBeAbleToSeeBelowProductTitlesAndPriceInThePage() {

    }

    @And("All the Product Images should be visible")
    public void allTheProductImagesShouldBeVisible() {
    }

    @And("Product description should be visible for all the products")
    public void productDescriptionShouldBeVisibleForAllTheProducts() {
    }

    @And("Product add to cart CTA should be visible for all products")
    public void productAddToCartCTAShouldBeVisibleForAllProducts() {
    }


    @Then("User lands on the Product details page")
    public void userLandsOnTheProductDetailsPage() {
    }

    @And("User should see Product Image in the page")
    public void userShouldSeeProductImageInThePage() {
    }

    @And("User clicks on the {string}")
    public void userClicksOnTheProductTitle(String s){

    }

    @And("User validates the Price as {int} in PDP Page")
    public void userValidatesThePriceInPDPPage(int a) {
    }

    @And("User validates the Product as {string} in PDP Page")
    public void userValidatesTheProductTitleInPDPPage(String s) {
    }

    @And("User validates the Description as {string} in PDP Page")
    public void userValidatesDescriptionInPDPPage(String arg0) {
    }

}
