package co.com.choucair.automation.startshap.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static co.com.choucair.automation.startshap.userinterface.LoginPage.*;

public class Login implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(USERNAME),
                Clear.field(USERNAME),
                Enter.theValue("admin").into(USERNAME),
                MoveMouse.to(PASSWORD),
                Clear.field(PASSWORD),
                Enter.theValue("serenity").into(PASSWORD),
                Click.on(BUTTON_SIGN_IN)
        );
    }

    public static Login in(){
        return Tasks.instrumented(Login.class);
    }
}
