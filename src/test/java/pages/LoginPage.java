package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By USER_NAME_FIELD = By.id("user-name"),
            PASSWORD_FIELD = By.id("password"),
            LOGIN_BUTTON = By.id("login-button"),
            ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public ProductsPage login(String user, String password) {
        driver.findElement(USER_NAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
