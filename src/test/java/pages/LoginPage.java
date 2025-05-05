package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }
        private final By USER_NAME_FIELD = By.id("user-name"),
                PASSWORD_FIELD = By.id("password"),
                LOGIN_BUTTON = By.id("login-button"),
                ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

        public void open() {
            driver.get("https://www.saucedemo.com/");
        }
        public void login(String user, String password) {
            driver.findElement(USER_NAME_FIELD).sendKeys(user);
            driver.findElement(PASSWORD_FIELD).sendKeys(password);
            driver.findElement(LOGIN_BUTTON).click();
        }
        public String getErrorMessage() {
            return driver.findElement(ERROR_MESSAGE).getText();
    }
}
