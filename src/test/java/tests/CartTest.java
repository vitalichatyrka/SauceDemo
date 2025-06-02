package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    @Epic("Cart")
    @Feature("Adding item to cart")
    @Story("Displaying added items in the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Chatyrka")
    @Description("Checking adding items to the cart")
    @Flaky
    @Link(name = "documentation", url = "https://www.saucedemo.com/")
    @TmsLink("TMS_1")
    @Issue("TMS-11")
    public void addItemToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCard("Sauce Labs Backpack");
        productsPage.openCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "SO BAAAAD");
        assertEquals(cartPage.getProductFromCart(0),
                "Sauce Labs Backpack",
                "SO BAAAAAD");
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), 29.99);
        softAssert.assertAll();
    }
}
