package Pages;

import BaseClasses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class = \"title\"]")
    private WebElement checkOutPage;

    @FindBy(id = "first-name")
    private WebElement firstname;

    @FindBy(id = "last-name")
    private WebElement lastname;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "postal-code")
    private WebElement zipcode;

    @FindBy(id = "finish")
    private WebElement finish;

    @FindBy(xpath = "//h2[@class = \"complete-header\"]")
    private WebElement successMsg;

    public String getSuccessMsg(){
        return successMsg.getText();
    }

    public void clickFinish(){
        click(finish);
    }

    public void inputZipCode(String text){
        enterText(zipcode, text);
    }

    public void clickContinueBtn(){
        click(continueBtn);
    }

    public void inputFirstname(String text){
        enterText(firstname, text);
    }

    public void inputLastname(String text){
        enterText(lastname, text);
    }

    public boolean verifyUserIsOnCheckOutPage(){
        return checkOutPage.isDisplayed();
    }
}
