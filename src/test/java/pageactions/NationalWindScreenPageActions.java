package pageactions;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.BaseClass;
import java.util.List;

public class NationalWindScreenPageActions extends BaseClass {
    public static String SUBMIT_BUTTON = "//button[@title='Next']";
    public static void verifyThePage(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    public static void iFillTheOnlineFormAnClickNext(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String vehicle_vrm = data.get(1).get(1);
        String name = data.get(2).get(1);
        String phoneNumber = data.get(3).get(1);
        String email = data.get(4).get(1);
        interactionUtils.tyText(By.id(data.get(1).get(0)),vehicle_vrm);
        interactionUtils.tyText(By.id(data.get(2).get(0)),name);
        interactionUtils.tyText(By.id(data.get(3).get(0)),phoneNumber);
        interactionUtils.tyText(By.id(data.get(4).get(0)),email);
        interactionUtils.acceptCookies();
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
        interactionUtils.implicitWait(30);
    }
    public static void selectTheDateAndClickNextButton(int day) {
        driver.findElement(By.xpath("//*[@id='damage-datepicker']//span[@class='cell day'][contains(text(),'" + day + "')]")).click();
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public static void verifyThePageResponse(String expectedPageResponse) {
        WebElement element = interactionUtils.waitForElementVisibility(By.xpath("//*[@id='main']//h2"),20);
        String actualResponse = element.getText();
        Assert.assertEquals(expectedPageResponse, actualResponse);
    }
}
