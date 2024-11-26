package Pages;

import BaseClasses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageBase {
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"fi-q\"]")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class=\"btn _prim _md -mls -fsh0\"]")
    private WebElement searchBtn;

    @FindBy(xpath = "//h3[@class= \"name\"]")
    private WebElement product;

    @FindBy(xpath = "//button[@class= \"add btn _prim -pea _md\"]")
    private WebElement add2CartBtn;

    @FindBy(xpath = "//button[@class = \"btn _prim -df -mla\"]")
    private WebElement cookies;

    @FindBy(xpath = "//div[@class = \"cnt\"]")
    private WebElement productAddedToCartMsg;

    @FindBy(xpath = "//span[@id = \"ci\"]")
    private WebElement cartIcon;

    @FindBy(xpath = "//a[@class = \"btn _prim _md -fw\"]")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class = \"-df -fw-w -paxs -pbs -bb\"]")
    private WebElement scroll;

    @FindBy(xpath = "//span[@class = \"ic-bg\"]")
    private WebElement cancelBtn;

    public void clickCancelBtn(){
        click(cancelBtn);
    }


    public void clickCheckOutBtn(){
        click(checkoutBtn);
    }

    public void clickAdd2CartIcon(){
        click(cartIcon);
    }

    public boolean ValidateProductAddedToCart(){
        return productAddedToCartMsg.isDisplayed();
    }

    public void clickAcceptCookiesBtn(){
        click(cookies);
    }

    public void clickAddToCartBtn() {
        scrollTo(scroll);
        hoverOnProduct();
        click(add2CartBtn);
    }

    public void hoverOnProduct(){
        Actions actions = new Actions(driver);
        actions.moveToElement(add2CartBtn).perform();
    }

    public String productText(){
        System.out.println(product.getText());
        return product.getText();
    }

    public void EnterTextInSearchBox(String text){
        enterText(searchBox, text);
    }

    public void clickSearchBtn(){
        click(searchBtn);
    }
}
