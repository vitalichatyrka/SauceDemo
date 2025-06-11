package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
        log.info("Opening products page {}", productsPageUrl);
        driver.get(productsPageUrl);
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        log.info("Checking products page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    public String getTitle() {
        log.info("Getting title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    public ProductsPage addToCard(String productName) {
        log.info("Adding product to cart");
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, productName))).click();
        return this;
    }

    public CartPage openCart() {
        log.info("Opening the cart page");
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }
}
