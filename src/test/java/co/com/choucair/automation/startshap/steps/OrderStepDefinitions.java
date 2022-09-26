package co.com.choucair.automation.startshap.steps;

import co.com.choucair.automation.startshap.questions.ReviewData;
import co.com.choucair.automation.startshap.task.AddOrder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;

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

    @When("fill data form")
    public void fillDataForm() {
        theActorInTheSpotlight().attemptsTo(AddOrder.fill());
    }

    @Then("see the register")
    public void seeTheRegister() {

    }



}
