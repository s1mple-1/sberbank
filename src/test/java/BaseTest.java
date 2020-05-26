import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @BeforeEach
    void initDriver() {
/*     change String 'browser' to needed
 available: for chrome - 'ch', for opera - 'op', for firefox = 'ff'*/
        String browser = "ff";

        switch (browser) {
            case "ch":
                System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "op":
                System.setProperty("webdriver.opera.driver", "webdrivers/operadriver.exe");
                webDriver = new OperaDriver();
                break;
            case "ff":
                System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 20);
    }

    @AfterEach
    void quitDriver() {
        webDriver.quit();
    }


    void getSite(String url) {
        webDriver.get(url);
    }


    void findElementAndClick(String xPath) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        WebElement webElement = webDriver.findElement(By.xpath(xPath));
        try {
            webElement.click();
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click()", webElement);
        }
    }

    void sendTextToForm(String text, String xPath) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        WebElement webElement = webDriver.findElement(By.xpath(xPath));
        webElement.click();
        webElement.sendKeys(text);
    }

    void checkTextInForm(String expected, String xPath) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        String actual = webDriver.findElement(By.xpath(xPath)).getAttribute("value");
        Assertions.assertEquals(expected, actual, String.format("Ожидаемое содержание '%s', фактическое '%s'", expected, actual));
    }

    void checkElementVisibility(String xPath) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement webElement = webDriver.findElement(By.xpath(xPath));
        Assertions.assertTrue(webElement.isDisplayed(), "Элемент не отображается");
    }
}