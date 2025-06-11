package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CheckoutPages.CheckoutInformationPage;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.xpath("//button[@data-test='checkout']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage open() {
        log.info("Opening CartPage {}", BASE_URL + "/cart.html");
        driver.get(BASE_URL + "/cart.html");
        return this;
    }

    @Override
    public CartPage isPageOpened() {
        log.info("Checking that cart page is opend");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class='header_secondary_container']//ancestor::span")));
        return this;
    }

    public boolean isProductInCart(String product) {
        log.info("Checking that product  is in the cart");
        return driver.findElement(By.xpath(String.format("//*[text()='Sauce Labs Backpack']",
                product))).isDisplayed();
    }

    public String getProductFromCart(int index) {
        log.info("Getting  product from the cart");
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }

    public ArrayList<String> getProductsName() {
        log.info("Getting  product name from the cart");
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Getting price of product with name: {product} in the cart")
    public double getProductPrice(String product) {
        log.info("Getting  product price from the cart");
        return Double.parseDouble(driver.findElement(
                        By.xpath(String.format(
                                "//*[text() = '%s']/ancestor::div[@class='cart_item']//" +
                                        "*[@class = 'inventory_item_price']", product)))
                .getText().replace("$", ""));
    }

    public CheckoutInformationPage openCheckoutInformationPage() {
        log.info("Opening  checkout information page");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutInformationPage(driver);
    }
}
