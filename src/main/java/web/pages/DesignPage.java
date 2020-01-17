package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.BasePage;


public class DesignPage extends BasePage {

    public DesignPage(WebDriver driver) {
        super(driver);
    }



    private final Logger log = LoggerFactory.getLogger(DesignPage.class);

    @FindBy(xpath = "(//*[@id='__id1']//*[@role='button']) [2]")
    private WebElement MENU_PHOTO;

    @FindBy(xpath = "(//*[@id='__id3']//img) [1]")
    private WebElement MENU_PHOTO_FIRST_IMG;



    @Step("Click on the Photo menu item")
    private void clickPhotoMenu(){
        this.MENU_PHOTO.click();
    }

    @Step("Choose any first from menu")
    private void chooseFirstPhotoFromMenu(){
        this.MENU_PHOTO_FIRST_IMG.click();
    }

    @Step("Choose any photo from menu and add into document")
    public void addImageIntoDocument() {
        this.clickPhotoMenu();
        this.chooseFirstPhotoFromMenu();
    }
}
