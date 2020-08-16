package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='header-bottom__right flex-wrap middle-xs end-xs']/a[contains(@href, 'sign-in')]")
    private WebElement signIn;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and @class='button-reset main-btn submit main-btn--green']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='col-xs-12 js_message']")
    private WebElement errorPopup;

    @FindBy(xpath = "//a[contains(@href, 'sign-up')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phoneFieldSignUp;

    @FindBy(xpath = "//input[@name='email' and @type='email']")
    private WebElement emailFieldSignUp;

    @FindBy(xpath = "//input[@class='validate password show-password']")
    private WebElement passwordFieldSignUp;

    @FindBy(xpath = "//input[@class='validate password_1 show-password']")
    private WebElement passwordValidateFieldSignUp;

    @FindBy(xpath = "//button[@class='button-reset main-btn js_validate submit main-btn--green']")
    private WebElement submitSignUpForm;

    @FindBy(xpath = "//div[@class='col-xs-12 js_message' and contains(text(), 'отправлен код подтверждения')]")
    private WebElement codeConfirmationPopup;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton() { signIn.click(); }

    public void fillInLogin(String login) {
        loginField.sendKeys(login);
    }

    public void fillInPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitSignInForm() {
        submitButton.click();
    }

    public boolean errorPopupState() {
        return errorPopup.isDisplayed();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void fillInPhoneNumber(String phone) {
        phoneFieldSignUp.sendKeys(phone);
    }

    public void fillInEmail(String email) {
        emailFieldSignUp.sendKeys(email);
    }

    public void fillInPasswordSignUp(String password) {
        passwordFieldSignUp.sendKeys(password);
    }

    public void validatePassword(String password) {
        passwordValidateFieldSignUp.sendKeys(password);
    }

    public void submitSignUpForm() {
        submitSignUpForm.click();
    }

    public boolean codeConfirmationState() {
        return codeConfirmationPopup.isDisplayed();
    }
}
