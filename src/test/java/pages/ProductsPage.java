package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.cssSelector("[data-test=title]");
    private static final String productsPageUrl = "https://www.saucedemo.com/inventory.html";
    private static final By CART_BUTTON = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private static final String ADD_TO_CART_PATTERN = "//*[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage open() {
        driver.get(productsPageUrl);
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    public ProductsPage addToCard(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, productName))).click();
        return this;
    }

    public CartPage openCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }
}
