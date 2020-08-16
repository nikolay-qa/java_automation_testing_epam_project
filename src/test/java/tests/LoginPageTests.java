package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest{

    private static final String LOGIN = "java@python.com";
    private static final String PASSWORD = "1234567890";
    private static final String SIGNUP = "https://avic.ua/sign-up";
    private static final String NEWPHONENUMBER = "0689875699"; // use test phone number for this test that is not registered in the database

    @Test(priority = 1)
    public void checkThatLoginPageLinkIsCorrectAndOpened() {
        getLoginPage().clickOnSignInButton();
        getBasePage().waitForPageLoadComplete(30);
        assertTrue(driver.getCurrentUrl().contentEquals("https://avic.ua/sign-in"));
    }
    @Test(priority = 2)
    public void checkThatErrorPopupIsShownAfterLoginWithWrongLoginAndPassword() {
        getLoginPage().clickOnSignInButton();
        getBasePage().waitForPageLoadComplete(30);
        getLoginPage().fillInLogin(LOGIN);
        getLoginPage().fillInPassword(PASSWORD);
        getLoginPage().submitSignInForm();
        getBasePage().waitForPageLoadComplete(30);
        assertTrue(getLoginPage().errorPopupState());
    }

    @Test(priority = 3)
    public void checkThatSignUpPageIsLoadedFromLoginPage() {
        getLoginPage().clickOnSignInButton();
        getBasePage().waitForPageLoadComplete(30);
        getLoginPage().clickSignUpButton();
        getBasePage().waitForPageLoadComplete(30);
        assertTrue(driver.getCurrentUrl().contentEquals(SIGNUP));
    }

    @Test(priority = 4)
    public void checkThatPopupAboutCodeIsShownAfterSignUp() {
        getLoginPage().clickOnSignInButton();
        getBasePage().waitForPageLoadComplete(30);
        getLoginPage().clickSignUpButton();
        getBasePage().waitForPageLoadComplete(30);
        getLoginPage().fillInPhoneNumber(NEWPHONENUMBER);
        getLoginPage().fillInEmail(LOGIN);
        getLoginPage().fillInPasswordSignUp(PASSWORD);
        getLoginPage().validatePassword(PASSWORD);
        getLoginPage().submitSignUpForm();
        getBasePage().waitForPageLoadComplete(30);
        assertTrue(getLoginPage().codeConfirmationState());
    }
}
