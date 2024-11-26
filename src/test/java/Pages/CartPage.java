package Pages;

import BaseClasses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = \"inventory_item_name\"]")
    private WebElement itemInCart;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public void clickOnCheckOutBtn(){
        click(checkoutBtn);
    }

    public String ProductInCart(){
        return itemInCart.getText();
    }
}
