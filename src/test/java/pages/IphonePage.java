package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IphonePage extends BasePage {

    @FindBy(xpath = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Green (MWC62)')]")
    private WebElement addToCartButton;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    public IphonePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }
}
