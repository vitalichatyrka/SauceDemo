package pages.CheckoutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.ProductsPage;

public class CheckoutInformationPage extends BasePage {
    private final By FIRST_NAME_FIELD = By.id("first-name"),
            LAST_NAME_FIELD = By.id("last-name"),
            ZIP_POSTAL_CODE = By.id("postal-code"),
            CONTINUE_BUTTON = By.xpath(
                    "//input[@data-test='continue']"),
            ERROR_MESSAGE = By.cssSelector("h3[data-test='error']"),
            CANCEL_BUTTON = By.xpath(
                    "//button[@class='btn btn_secondary back btn_medium cart_cancel_link']");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    @Override
    public CheckoutInformationPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class='header_secondary_container']//ancestor::span")));
        return this;
    }

    public CheckoutInformationPage enterFirstName(String userName) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(userName);
        return this;
    }

    public CheckoutInformationPage enterLastName(String lastName) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        return this;
    }

    public CheckoutInformationPage enterPostalCode(String postalCode) {
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(postalCode);
        return this;
    }

    public CheckoutOverviewPage clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }

    public ProductsPage clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
