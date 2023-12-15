package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static pageactions.HomePageActions.*;

public class HomePageStepDefs {

    @Given("I am on the ers homepage")
    public void iAmOnTheErsHomePage() {
        verifyTheUserIsOnHomePage();
    }

    @When("I click {string} from the main navigation")
    public void iClickClaimsFromTheMainNavigation(String mainNavOptions) {
        clickOnClaimsOnTheMainMenu(mainNavOptions);
    }

    @And("I click on the {string} option for the Windscreen repair")
    public void iClickOnTheBookOnlineOptionForTheWindscreenRepair(String claimOption) {
        clickBookOnlineButton(claimOption);
    }
}
