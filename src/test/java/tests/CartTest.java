package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCart() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .addToCard("Sauce Labs Backpack")
                .openCart()
                .isPageOpened()
                .isProductInCart("Sauce Labs Backpack");

/*        loginPage.open();
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
        softAssert.assertAll();*/
    }
}
