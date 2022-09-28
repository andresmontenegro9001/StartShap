package co.com.choucair.automation.startshap.steps;

import co.com.choucair.automation.startshap.questions.ReviewData;
import co.com.choucair.automation.startshap.task.AddBasicOrder;
import co.com.choucair.automation.startshap.task.AddDetailOrder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

import static co.com.choucair.automation.startshap.userinterface.DashboardPage.LINK_ORDERS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class OrderStepDefinitions {

    @Given("Need add order")
    public void needAddOrder() {
        theActorInTheSpotlight().wasAbleTo(Click.on(LINK_ORDERS));
        theActorInTheSpotlight().should(seeThat(ReviewData.ordersTitle(),equalTo("Orders")));
    }

    @When("fill data form general")
    public void fillDataFormGeneral(List<Map<String, String>> params) {
        theActorInTheSpotlight().attemptsTo(AddBasicOrder.fill(params));
    }

    @When("fill order detail")
    public void fillOrderDetail(List<Map<String, String>> params) {
        theActorInTheSpotlight().attemptsTo(AddDetailOrder.fill(params));
    }

    @Then("see the register created")
    public void seeTheRegisterCreated() {

    }



}
