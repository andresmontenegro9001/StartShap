package co.com.choucair.automation.startshap.task;

import co.com.choucair.automation.startshap.models.Order;
import co.com.choucair.automation.startshap.utils.StopExecution;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.choucair.automation.startshap.userinterface.DashboardPage.BUTTON_NEW_ORDER;
import static co.com.choucair.automation.startshap.userinterface.OrderPage.*;

public class AddOrder implements Task {

    private Map<String, String> map;
    private Order order;

    public AddOrder(List<Map<String, String>> params) {
        this.map = new HashMap<>();
        this.map = params.get(0);
        ObjectMapper mapper = new ObjectMapper();
        this.order = mapper.convertValue(map, Order.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_NEW_ORDER),

                Click.on(SELECT_CUSTOMER),
                MoveMouse.to(INPUT_SEARCH_CUSTOMER),
                SendKeys.of(this.order.getCustomer()).into(INPUT_SEARCH_CUSTOMER),
                SendKeys.of(Keys.ENTER).into(INPUT_SEARCH_CUSTOMER),

                MoveMouse.to(ORDER_DATE),
                Clear.field(ORDER_DATE),
                SendKeys.of(this.order.getOrderDate()).into(ORDER_DATE),

                MoveMouse.to(REQUIRED_DATE),
                SendKeys.of(this.order.getRequiredDate()).into(REQUIRED_DATE),

                Click.on(SELECT_EMPLOYEE),
                MoveMouse.to(INPUT_SEARCH_EMPLOYEE),
                SendKeys.of(this.order.getEmployee()).into(INPUT_SEARCH_EMPLOYEE),
                SendKeys.of(Keys.ENTER).into(INPUT_SEARCH_EMPLOYEE),

                Click.on(BUTTON_NEW_ORDER_DETAIL),

                Click.on(SELECT_PRODUCT),
                MoveMouse.to(INPUT_SEARCH_PRODUCT),
                SendKeys.of(this.order.getProduct()).into(INPUT_SEARCH_PRODUCT),
                SendKeys.of(Keys.ENTER).into(INPUT_SEARCH_PRODUCT),

                MoveMouse.to(INPUT_UNIT_PRICE),
                Clear.field(INPUT_UNIT_PRICE),
                SendKeys.of(this.order.getUnitPrice()).into(INPUT_UNIT_PRICE),

                MoveMouse.to(INPUT_QUANTITY),
                Clear.field(INPUT_QUANTITY),
                SendKeys.of(this.order.getQuantity()).into(INPUT_QUANTITY),

                MoveMouse.to(INPUT_DISCOUNT),
                Clear.field(INPUT_DISCOUNT),
                SendKeys.of(this.order.getDiscount()).into(INPUT_DISCOUNT),

                MoveMouse.to(BUTTON_SAVE_NEW_ORDER_DETAIL),
                Click.on(BUTTON_SAVE_NEW_ORDER_DETAIL)
        );
        StopExecution.stop(5000);
    }

    public static AddOrder fill(List<Map<String, String>> params) {
        return Tasks.instrumented(AddOrder.class, params);
    }
}
