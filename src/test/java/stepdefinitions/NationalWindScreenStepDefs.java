package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.time.LocalDate;

import static pageactions.NationalWindScreenPageActions.*;

public class NationalWindScreenStepDefs {

    @Then("I navigated to the {string}")
    public void iNavigatedToThe(String expectedUrl) {
        verifyThePage(expectedUrl);
    }

    @And("I fill the online appoint form")
    public void iFillTheOnlineAppointForm(DataTable dataTable) {
        iFillTheOnlineFormAnClickNext(dataTable);
    }

    @And("I select the date and click next button")
    public void iSelectTheDateAndClickNextButton() {
        selectTheDateAndClickNextButton(LocalDate.now().minusDays(1).getDayOfMonth());
    }

    @Then("I should get {string} message")
    public void iShouldGetPolicyNotFoundMessage(String expectedResponse) {
        verifyThePageResponse(expectedResponse);
    }
}
