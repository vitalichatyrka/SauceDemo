package pages.CheckoutPages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class CheckoutOverviewPage extends BasePage {

    private final By TITLE_OF_CHECKOUT_OVERVIEW_PAGE = By.xpath(
            "//span[@data-test='title']");
    private final String NAME_OF_TITLE_OF_CHECKOUT_OVERVIEW_PAGE = "Checkout: Overview";

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        return null;
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public String getPageTitle() {
        log.info("Getting page title {}", TITLE_OF_CHECKOUT_OVERVIEW_PAGE);
        return driver.findElement(TITLE_OF_CHECKOUT_OVERVIEW_PAGE).getText();
    }

    public boolean isTitleCorrect() {
        log.info("Checking that page title is correct {}", TITLE_OF_CHECKOUT_OVERVIEW_PAGE);
        return getPageTitle().equals(NAME_OF_TITLE_OF_CHECKOUT_OVERVIEW_PAGE);
    }
}
