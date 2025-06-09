package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Epic("Authorization")
    @Feature("Login page")
    @Story("Success login")
    public void checkLogin() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .isPageOpened();
        assertEquals(productsPage.getTitle(), "Products", "Логин не выполнен");
    }

    @Test(testName = "Check login with empty password", enabled = true, priority = 2, groups = {"smoke"})
    public void checkLoginWithEmptyPasswordAndUsername() {
        loginPage.open()
                .isPageOpened()
                .login("", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required1", "Login successful but shouldn't");
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkLoginWithEmptyPassword() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required", "Login successful but shouldn't");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void checkLoginErrors(String user, String password, String errorMessage) {
        loginPage.open()
                .isPageOpened()
                .login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                errorMessage, "Incorrect error message");
    }
}
