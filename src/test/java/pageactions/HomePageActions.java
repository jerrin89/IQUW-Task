package pageactions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.BaseClass;
import util.InteractionUtils;

public class HomePageActions extends BaseClass {
    public static String BASEURL = "https://www.ers.com/claims";

    public static void verifyTheUserIsOnHomePage() {
        driver.navigate().to(BASEURL);
        Assert.assertEquals(BASEURL, driver.getCurrentUrl());
    }

    public static void clickOnClaimsOnTheMainMenu(String mainNavOptions) {
        driver.findElement(By.xpath("//*[@id='responsive-menu']//li[5]//a[contains(text(),'" + mainNavOptions + "')]")).click();
    }

    public static void clickBookOnlineButton(String claimOption) {
         By bookOnlineLocator = By.xpath("//*[@id='content']//a[contains(text(),'" + claimOption + "')]");
         interactionUtils.clickOn(bookOnlineLocator);
    }

}
