package Pages;

import BaseClasses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test = \"error\"]")
    private WebElement errorMsg;

    @FindBy(xpath = "//span[@class = \"title\"]")
    private WebElement prod;

    public boolean PDP(){
        return prod.isDisplayed();
    }

    public boolean errorMsg(){
        return errorMsg.isDisplayed();
    }

    public void inputUsername(String text) {
        enterText(usernameField, text);
    }

    public void clearUserNameField(){
        clear(usernameField);
    }

    public void clearPasswordField(){
        clear(passwordField);
    }

    public void inputPassword(String text) {
        enterText(passwordField, text);
    }

    public void clickLogin() {
        click(loginBtn);
    }

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
}




