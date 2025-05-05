package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCard("Sauce Labs Backpack");
        productsPage.openCart();
    }
}
