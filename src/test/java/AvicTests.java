import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class AvicTests {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test(priority = 1)
    public void checkThatLoginPageLinkIsCorrectAndOpened() {
        driver.findElement(By.xpath("//div[@class='header-bottom__right flex-wrap middle-xs end-xs']/a[contains(@href, 'sign-in')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        assertTrue(driver.getCurrentUrl().contentEquals("https://avic.ua/sign-in"));
    }

    @Test(priority = 2)
    public void checkThatErrorPopupIsShownAfterLoginWithWrongLoginAndPassword() {
        driver.findElement(By.xpath("//div[@class='header-bottom__right flex-wrap middle-xs end-xs']/a[contains(@href, 'sign-in')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("java@python.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456780");
        driver.findElement(By.xpath("//button[@type='submit' and @class='button-reset main-btn submit main-btn--green']")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        Boolean errorPopupState = driver.findElement(By.xpath("//div[@class='col-xs-12 js_message']")).isDisplayed();
        assertTrue(errorPopupState);
    }

    @Test(priority = 3)
    public void checkThatSignUpPageIsLoadedFromLoginPage() {
        driver.findElement(By.xpath("//div[@class='header-bottom__right flex-wrap middle-xs end-xs']/a[contains(@href, 'sign-in')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//a[contains(@href, 'sign-up')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        assertTrue(driver.getCurrentUrl().contentEquals("https://avic.ua/sign-up"));
    }

    @Test(priority = 4)
    public void checkThatPopupAboutCodeIsShownAfterSignUp() {
        driver.findElement(By.xpath("//div[@class='header-bottom__right flex-wrap middle-xs end-xs']/a[contains(@href, 'sign-in')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//a[contains(@href, 'sign-up')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("+38(068) 987 52 74"); // Please use test phone number for this test that is not registered in the database
        driver.findElement(By.xpath("//input[@name='email' and @type='email']")).sendKeys("java@python.com");
        driver.findElement(By.xpath("//input[@class='validate password show-password']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@class='validate password_1 show-password']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[@class='button-reset main-btn js_validate submit main-btn--green']")).click();
        Boolean codeConfirmationState = driver.findElement(By.xpath("//div[@class='col-xs-12 js_message' and contains(text(), 'отправлен код подтверждения')]")).isDisplayed();
        assertTrue(codeConfirmationState);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
