package util;

import org.openqa.selenium.WebDriver;
import pageactions.HomePageActions;
import pageactions.NationalWindScreenPageActions;
import util.Driver;
import util.InteractionUtils;

public class BaseClass {
    public static WebDriver driver = Driver.getDriver();
    public static InteractionUtils interactionUtils = new InteractionUtils();

}
