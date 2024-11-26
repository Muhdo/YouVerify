package Tests;

import BaseClasses.TestBase;
import Pages.LandingPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class test1 extends TestBase {

    LandingPage landingPage;

    public void initializer(){
        landingPage = new LandingPage(driver);
    }

    @Test(priority = 1, description = "Validate user is able to navigate to the site")
    public void TC_01(Method method){
        initializer();
        Assert.assertEquals(testData.getProperty("url"), "https://www.jumia.com.ng/");
    }

    @Test(priority = 2, description = "Validate user is able to search for a specific product")
    public void TC_02(Method method){

        landingPage.clickAcceptCookiesBtn();
        landingPage.EnterTextInSearchBox(testData.getProperty("product"));
        landingPage.clickSearchBtn();
        Assert.assertEquals(landingPage.productText(), testData.getProperty("product"));

    }

    @Test(priority = 3, description = "Validate user is able to add product to cart")
    public void TC_03(Method method){

        landingPage.clickAddToCartBtn();
        Assert.assertTrue(landingPage.ValidateProductAddedToCart(), "Product not added to cart");
        landingPage.clickCancelBtn();
        sleep(5);

    }

    @Test(priority = 4, description = "Validate user can proceed to checkout")
    public void TC_04(Method method){

        landingPage.clickAdd2CartIcon();
        landingPage.clickCheckOutBtn();
        //Find a way to show you can proceed to checkout button
        sleep(30);
    }


}
