package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.PropertyHolder;
import web.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement LINK_FOR_LOGIN;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement INPUT_USER_PASSWORD;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement BUTTON_SUBMIT;

    @FindBy(xpath = "//*[@inputmode='email']")
    private WebElement INPUT_USER_EMAIL;


    public IndexPage login() {
        log.info("Make a login");
        openLoginForm()
                .enterEmail(PropertyHolder.getPropValue("USER_EMAIL"))
                .enterPassword(PropertyHolder.getPropValue("USER_PASSWORD"))
                .submitLoginCreds();
        return new IndexPage(driver);
    }

    @Step("Enter email {email}")
    public LoginPage enterEmail(String email) {
        this.INPUT_USER_EMAIL.clear();
        this.INPUT_USER_EMAIL.sendKeys(email);
        return this;
    }

    @Step("Enter password {password}")
    public LoginPage enterPassword(String password) {
        this.INPUT_USER_PASSWORD.clear();
        this.INPUT_USER_PASSWORD.sendKeys(password);
        return this;
    }

    @Step("Open login form by clicking on link")
    public LoginPage openLoginForm() {
        this.LINK_FOR_LOGIN.click();
        return this;
    }

    @Step("Submit login form with credentials")
    public void submitLoginCreds() {
        this.BUTTON_SUBMIT.click();
    }


}
