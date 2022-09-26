package co.com.choucair.automation.startshap.steps;

import co.com.choucair.automation.startshap.questions.ReviewData;
import co.com.choucair.automation.startshap.task.Login;
import co.com.choucair.automation.startshap.userinterface.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    @Given("that a StartShap user has access")
    public void thatAStartShapUserHasAccess() {
        theActorInTheSpotlight().wasAbleTo(Open.browserOn(new LoginPage()));
    }

    @When("he submits username and password")
    public void heSubmitsUsernameAndPassword() {
        theActorInTheSpotlight().attemptsTo(Login.in());
    }

    @Then("he access and observes title {string}")
    public void heAccessAndObservesTitle(String dashBoardTitle) {
        theActorInTheSpotlight().should(seeThat(ReviewData.dashboardTitle(),equalTo(dashBoardTitle)));
    }
}
