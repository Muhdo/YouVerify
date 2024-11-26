package Tests;

import BaseClasses.TestBase;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public void initializer(){
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test(priority = 1, description = "Validate user is able to navigate to the site")
    public void TC_01(Method method){
        initializer();
        Assert.assertEquals(testData.getProperty("url"), "https://www.saucedemo.com/");
    }

    @Test(priority = 2, description = "Test case to verify that an error message is displayed for invalid login credentials")
    public void TC_02(Method method){
        loginPage.inputUsername(testData.getProperty("invalidUsername"));
        loginPage.inputPassword(testData.getProperty("invalidPassword"));
        loginPage.clickLogin();
        sleep(5);
        Assert.assertTrue(loginPage.errorMsg(), "The error message is not displayed");
    }

    @Test(priority = 3, description = "Test case to verify successful login")
    public void TC_03(Method method){
        loginPage.clearUserNameField();
        sleep(3);
        loginPage.inputUsername(testData.getProperty("validUsername"));
        sleep(2);
        loginPage.clearPasswordField();
        loginPage.inputPassword(testData.getProperty("validPassword"));
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.PDP(), "User is not on the Product display page");
        sleep(3);
    }

    @Test(priority = 4, description = "Test case to verify user can select product and add product to cart")
    public void TC_04(Method method){

        productPage.filterProduct(testData.getProperty("filterOption")); // filters the product display page by the filter parameter put in place
        productPage.clickOnProduct(testData.getProperty("product")); // This method loops through the products on the product display page and select which ever matches the search parameter
        sleep(3);
        Assert.assertEquals(productPage.getSelectedProduct(), testData.getProperty("product"), "The products searched for is not the product clicked on");  //This checks that the searched product is the product selected
        productPage.clickAddToCart();
        sleep(3);
    }

    @Test(priority = 5, description = "Test case to check if item is displayed in the cart")
    public void TC_05(Method method){

        productPage.clickCartIcon();
        Assert.assertEquals(cartPage.ProductInCart(), testData.getProperty("product")); //checks that it is the right product that is in cart
        cartPage.clickOnCheckOutBtn();
        sleep(3);

    }

    @Test(priority = 6, description = "Test case to check if user is on checkout page")
    public void TC_06(Method method){

        Assert.assertTrue(checkoutPage.verifyUserIsOnCheckOutPage(), "User is not on the checkout page");
        checkoutPage.inputFirstname(testData.getProperty("firstname"));
        checkoutPage.inputLastname(testData.getProperty("lastname"));
        checkoutPage.inputZipCode(testData.getProperty("zipcode"));
        checkoutPage.clickContinueBtn();
        sleep(3);
        checkoutPage.clickFinish();
        Assert.assertEquals(checkoutPage.getSuccessMsg(), testData.getProperty("successMessage"), "Success message not displayed to user");
        sleep(3);

    }



}
