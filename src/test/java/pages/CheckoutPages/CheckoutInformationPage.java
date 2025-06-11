package pages.CheckoutPages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.ProductsPage;

@Log4j2
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
        log.info("Opening base page {}", "https://www.saucedemo.com/checkout-step-one.html");
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    @Override
    public CheckoutInformationPage isPageOpened() {
        log.info("Checkout Information Page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class='header_secondary_container']//ancestor::span")));
        return this;
    }

    public CheckoutInformationPage enterFirstName(String userName) {
        log.info("Enter first name: {}", userName);
        driver.findElement(FIRST_NAME_FIELD).sendKeys(userName);
        return this;
    }

    public CheckoutInformationPage enterLastName(String lastName) {
        log.info("Enter last name: {}", lastName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        return this;
    }

    public CheckoutInformationPage enterPostalCode(String postalCode) {
        log.info("Enter postal code: {}", postalCode);
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(postalCode);
        return this;
    }

    public CheckoutOverviewPage clickContinueButton() {
        log.info("Clicking to continue button with xpath: {}", CONTINUE_BUTTON);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }

    public ProductsPage clickCancelButton() {
        log.info("Clicking to cancel button with xpath: {}", CANCEL_BUTTON);
        driver.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        log.info("Getting an error message with xpath: {}", ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
