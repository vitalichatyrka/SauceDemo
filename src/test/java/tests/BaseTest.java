package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.CheckoutPages.CheckoutInformationPage;
import pages.CheckoutPages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.Map;

public class BaseTest {

    WebDriver driver;
    ChromeOptions options;
    LoginPage loginPage;
    SoftAssert softAssert;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod
    public void setup() {
            options = new ChromeOptions();
            options.setExperimentalOption("prefs", Map.of(
                    "credentials_enable_service", false,
                    "profile.password_manager_enabled", false
            ));
            options.addArguments("--disable-features=PasswordManagerEnableLeakDetection,AutofillServerCommunication,PasswordCheck");
            options.addArguments("--disable-blink-features=PasswordCredential,CredentialManagerAPI");
            driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Test
    public void checkLocator() {
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
