package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class LocatorTest extends BaseTest {

    @Test
    public void checkLocator() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("password"));
        driver.findElement(By.className("error-message-container"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.className("login_logo"));
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(driver.findElement(By.linkText("Sauce Labs Backpack")).isDisplayed());
        assertTrue(driver.findElement(By.partialLinkText("Sauce Labs")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(
                "//a[@class='shopping_cart_link']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(
                "//button[text()='Add to cart']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(
                "//button[contains(text(),'Add')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(
                "//a[contains(@href,'https://twitter.com/')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(
                "//*[text()='LinkedIn']//ancestor::footer")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(
                "//ul[@class='social']//descendant::li")).isDisplayed());
        List<WebElement> socialMediaButtons = driver.findElements(By.xpath(
                "//ul[@class='social']//descendant::li"));
        for (WebElement socialMediaButton : socialMediaButtons) {
            System.out.println("Visible: " + socialMediaButton.getText());
        }
    }
}
