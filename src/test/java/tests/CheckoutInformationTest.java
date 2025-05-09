package tests;

import org.testng.annotations.Test;
import pages.config.Credentials;

import static org.testng.Assert.assertTrue;

public class CheckoutInformationTest extends BaseTest {
    @Test
    public void testSuccessfulCheckoutStepOne() {
        loginPage.open();
        loginPage.login(Credentials.getUsername(),Credentials.getPassword());
        productsPage.addToCard("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.openCheckoutInformationPage();
        checkoutInformationPage.enterFirstName(Credentials.getFirstName());
        checkoutInformationPage.enterLastName(Credentials.getLastName());
        checkoutInformationPage.enterPostalCode(Credentials.getPostalCode());
        checkoutInformationPage.clickContinueButton();
        assertTrue(checkoutOverviewPage.isTitleCorrect(),
                "First step of checkout is failed");
    }
        @Test
    public void testEmptyFirstNameShowsError() {
        loginPage.open();
        loginPage.login(Credentials.getUsername(),Credentials.getPassword());
        productsPage.addToCard("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.openCheckoutInformationPage();
        checkoutInformationPage.enterLastName(Credentials.getLastName());
        checkoutInformationPage.enterPostalCode(Credentials.getPostalCode());
        checkoutInformationPage.clickContinueButton();
        softAssert.assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: First Name is required");
    }
    @Test
    public void testEmptyLastNameShowsError() {
        loginPage.open();
        loginPage.login(Credentials.getUsername(),Credentials.getPassword());
        productsPage.addToCard("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.openCheckoutInformationPage();
        checkoutInformationPage.enterFirstName(Credentials.getFirstName());
        checkoutInformationPage.enterPostalCode(Credentials.getPostalCode());
        checkoutInformationPage.clickContinueButton();
        softAssert.assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: Last Name is required");
    }
    @Test
    public void testEmptyPostalCodeShowsError() {
        loginPage.open();
        loginPage.login(Credentials.getUsername(),Credentials.getPassword());
        productsPage.addToCard("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.openCheckoutInformationPage();
        checkoutInformationPage.enterFirstName(Credentials.getFirstName());
        checkoutInformationPage.enterLastName(Credentials.getLastName());
        checkoutInformationPage.clickContinueButton();
        softAssert.assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: Postal Code is required");
    }
    @Test
    public void testCancelButtonNavigatesBackToCart() {
        loginPage.open();
        loginPage.login(Credentials.getUsername(),Credentials.getPassword());
        productsPage.addToCard("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.openCheckoutInformationPage();
        checkoutInformationPage.clickCancelButton();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"));
    }
}
