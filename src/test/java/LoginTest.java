import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.tagName("div"));
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(title, "Products", "Логин не выполнен");
    }

    @Test
    public void checkLoginWithEmptyPasswordAndUsername() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath(
                "//h3[@data-test='error']")).getText(),
                "Epic sadface: Username is required");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath(
                "//h3[@data-test='error']")).getText(),
                "Epic sadface: Password is required");
    }
}
