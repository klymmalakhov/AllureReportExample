package web.pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//input")
    private WebElement INPUT_SEARCH;

    @FindBy(xpath = "//ul//button")
    private WebElement FIRST_SUGGESTION;

    @FindBy(xpath = "(//*[@target='_blank']) [2]")
    private WebElement FIRST_ITEM_FROM_SEARCH;

    @Step("Validate that menu is displayed")
    public IndexPage validateThatMenuDisplayed() {
        log.info("Validate the user menu");
        super.elementShouldBe(MENU_USER_NAME, "displayed");
        super.elementShouldBe(MENU_BUTTON_CREATE_DESIGN, "displayed");
        super.elementShouldBe(MENU_BUTTON_TRY_PRO, "displayed");
        super.elementShouldBe(MENU_ITEM_MAIN, "displayed");

        return this;
    }

    @Step("Search and open any item by {value} in search")
    public DesignPage searchAnyItem(String value){
        this.searchItem(value);
        this.chooseFirsSuggestion();
        this.chooseFirstItem();
        super.switchToNextTab();

        return new DesignPage(driver);
    }



    @Step("Search the item {value}")
    private void searchItem(String value){
        this.INPUT_SEARCH.click();
        this.INPUT_SEARCH.sendKeys(value);

    }

    @Step("Choose first suggestion")
    private void chooseFirsSuggestion(){
        wait(5);
        this.FIRST_SUGGESTION.click();
    }

    @Step("Select first item from the search result")
    private void chooseFirstItem(){
        this.FIRST_ITEM_FROM_SEARCH.click();
    }

}
