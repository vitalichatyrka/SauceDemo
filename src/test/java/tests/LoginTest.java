package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products", "Логин не выполнен");
    }

    @Test
    public void checkLoginWithEmptyPasswordAndUsername() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required", "Login successful but shouldn't");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required", "Login successful but shouldn't");
    }
}
