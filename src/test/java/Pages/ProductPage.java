package Pages;

import BaseClasses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@class = \"product_sort_container\"]")
    private WebElement filterBtn;

    @FindBy(xpath = "//div[@class = \"inventory_item_name \"]")
    private List<WebElement> products;

    @FindBy(id = "add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class = \"inventory_details_name large_size\"]")
    private WebElement selectedProduct;

    @FindBy(xpath = "//a[@class = \"shopping_cart_link\"]")
    private WebElement cartIcon;

    public void clickCartIcon(){
        click(cartIcon);
    }

    public String getSelectedProduct(){
        return selectedProduct.getText();
    }

    public void clickAddToCart(){
        click(addToCartBtn);
    }

    public void clickOnProduct(String text){
        int i;
        for(i = 0; i<products.size(); i++){
            if(text.equalsIgnoreCase(products.get(i).getText())){
                click(products.get(i));
                break;
            }
        }

    }

    public void filterProduct(String filterOption){
        Select select = new Select(filterBtn);
        select.selectByVisibleText(filterOption);
    }

}
