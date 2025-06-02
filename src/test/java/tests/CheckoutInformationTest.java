package tests;

import org.testng.annotations.Test;
import pages.config.Credentials;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutInformationTest extends BaseTest {
    @Test
    public void testSuccessfulCheckoutStepOne() {
        loginPage.open()
                .isPageOpened()
                .login(Credentials.getUsername(), Credentials.getPassword())
                .open()
                .isPageOpened()
                .addToCard("Sauce Labs Backpack")
                .openCart()
                .isPageOpened()
                .openCheckoutInformationPage()
                .isPageOpened()
                .enterLastName(Credentials.getLastName())
                .enterFirstName(Credentials.getFirstName())
                .enterPostalCode(Credentials.getPostalCode())
                .clickContinueButton();
        assertTrue(checkoutOverviewPage.isTitleCorrect(),
                "First step of checkout is failed");
    }

    @Test
    public void testEmptyFirstNameShowsError() {
        loginPage.open()
                .isPageOpened()
                .login(Credentials.getUsername(), Credentials.getPassword())
                .open()
                .isPageOpened()
                .addToCard("Sauce Labs Backpack")
                .openCart()
                .isPageOpened()
                .openCheckoutInformationPage()
                .isPageOpened()
                .enterLastName(Credentials.getLastName())
                .enterPostalCode(Credentials.getPostalCode())
                .clickContinueButton();
        assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: First Name is required");
    }

    @Test
    public void testEmptyLastNameShowsError() {
        loginPage.open()
                .isPageOpened()
                .login(Credentials.getUsername(), Credentials.getPassword())
                .open()
                .isPageOpened()
                .addToCard("Sauce Labs Backpack")
                .openCart()
                .isPageOpened()
                .openCheckoutInformationPage()
                .isPageOpened()
                .enterFirstName(Credentials.getFirstName())
                .enterPostalCode(Credentials.getPostalCode())
                .clickContinueButton();
        assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: Last Name is required");
    }

    @Test
    public void testEmptyPostalCodeShowsError() {
        loginPage.open()
                .isPageOpened()
                .login(Credentials.getUsername(), Credentials.getPassword())
                .open()
                .isPageOpened()
                .addToCard("Sauce Labs Backpack")
                .openCart()
                .isPageOpened()
                .openCheckoutInformationPage()
                .isPageOpened()
                .enterFirstName(Credentials.getFirstName())
                .enterLastName(Credentials.getLastName())
                .clickContinueButton();
        assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: Postal Code is required");
    }

    @Test
    public void testCancelButtonNavigatesBackToCart() {
        loginPage.open()
                .isPageOpened()
                .login(Credentials.getUsername(), Credentials.getPassword())
                .open()
                .isPageOpened()
                .addToCard("Sauce Labs Backpack")
                .openCart()
                .isPageOpened()
                .openCheckoutInformationPage()
                .isPageOpened()
                .clickCancelButton()
                .isPageOpened();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"));
    }
}
