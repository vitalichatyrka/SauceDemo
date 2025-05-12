package pages.CheckoutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutOverviewPage extends BasePage {

    private final By TITLE_OF_CHECKOUT_OVERVIEW_PAGE = By.xpath(
            "//span[@data-test='title']");
    private final String NAME_OF_TITLE_OF_CHECKOUT_OVERVIEW_PAGE = "Checkout: Overview";

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(TITLE_OF_CHECKOUT_OVERVIEW_PAGE).getText();
    }
    public boolean isTitleCorrect() {
        return getPageTitle().equals(NAME_OF_TITLE_OF_CHECKOUT_OVERVIEW_PAGE);
    }
}
