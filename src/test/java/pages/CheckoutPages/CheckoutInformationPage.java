package pages.CheckoutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

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

    public void enterFirstName(String userName) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(userName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(postalCode);
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
