package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.BasePage;


public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    private final Logger log = LoggerFactory.getLogger(IndexPage.class);

    @FindBy(xpath = "//aside//button[1]//p")
    private WebElement MENU_USER_NAME;

    @FindBy(xpath = "(//aside//button)[2]")
    private WebElement MENU_BUTTON_CREATE_DESIGN;

    @FindBy(xpath = "(//aside//button)[3]")
    private WebElement MENU_BUTTON_TRY_PRO;

    @FindBy(xpath = "//aside//a[@href='/']")
    private WebElement MENU_ITEM_MAIN;


    public void validateThatMenuDisplayed() {
        log.info("Validate the user menu");
        super.elementShouldBe(MENU_USER_NAME, "displayed");
        super.elementShouldBe(MENU_BUTTON_CREATE_DESIGN, "displayed");
        super.elementShouldBe(MENU_BUTTON_TRY_PRO, "displayed");
        super.elementShouldBe(MENU_ITEM_MAIN, "displayed");


    }
}
