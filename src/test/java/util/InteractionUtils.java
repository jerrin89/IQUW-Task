package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InteractionUtils extends BaseClass {
    private final long DEFAULT_TIMEOUT_SECONDS = 20;
    private final Logger log = LoggerFactory.getLogger(InteractionUtils.class);

    public void implicitWait(int time) {
    driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
}

    public  WebElement waitForElementVisibility(By locator,int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time)); // Adjust the timeout as needed
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void tyText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void clickOn(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
            element.click();
        } catch (StaleElementReferenceException e) {
            logAndHandleException("Caught Stale element reference, retrying click", e);
        } catch (ElementNotInteractableException e) {
            logAndHandleException("Element is not interactable, attempting to scroll into view and retrying click", e);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(selector)).perform();
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
            element.click();
        } catch (TimeoutException e) {
            logAndHandleException("Timeout waiting for element to be clickable", e);
        }
    }

    private void logAndHandleException(String message, Exception e) {
        log.warn(message);
        e.printStackTrace();
    }


    public void scrollDown(int count) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Scroll down by 2 times the viewport height
        for (int i = 0; i < count; i++) {
            jsExecutor.executeScript("window.scrollBy(0, window.innerHeight);");
        }
    }

    public  void acceptCookies() {
        By acceptButtonLocator = By.xpath("//*[@id='cookieconsent:desc']//a/../following-sibling::div//a");
        // Check if the accept button is present
        if (driver.findElements(acceptButtonLocator).size() > 0) {
            // If present, click the accept button
            WebElement acceptButton = driver.findElement(acceptButtonLocator);
            acceptButton.click();
        }
    }
}
