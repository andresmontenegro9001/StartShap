package co.com.choucair.automation.startshap.task;

import co.com.choucair.automation.startshap.models.BasicOrder;
import co.com.choucair.automation.startshap.utils.StopExecution;
import co.com.choucair.automation.startshap.utils.TypeObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.choucair.automation.startshap.userinterface.DashboardPage.BUTTON_NEW_ORDER;
import static co.com.choucair.automation.startshap.userinterface.OrderPage.*;

public class AddBasicOrder implements Task {

    private Map<String, String> map;
    private BasicOrder basicOrder;

    public AddBasicOrder(List<Map<String, String>> params) {
        this.map = new HashMap<>();
        this.map = params.get(0);
        ObjectMapper mapper = new ObjectMapper();
        this.basicOrder = mapper.convertValue(map, BasicOrder.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                ManageItem.goButton(TypeObject.BUTTON, BUTTON_NEW_ORDER),
                ManageItem.goSelect(TypeObject.SELECT, SELECT_CUSTOMER, INPUT_SEARCH_CUSTOMER ,this.basicOrder.getCustomer()),
                ManageItem.goInput(TypeObject.INPUT_FILLED, ORDER_DATE,this.basicOrder.getOrderDate()),
                ManageItem.goInput(TypeObject.INPUT_EMPTY,REQUIRED_DATE, this.basicOrder.getRequiredDate()),
                ManageItem.goSelect(TypeObject.SELECT,SELECT_EMPLOYEE,INPUT_SEARCH_EMPLOYEE,this.basicOrder.getEmployee())
        );
        StopExecution.stop(5000);
    }

    public static AddBasicOrder fill(List<Map<String, String>> params) {
        return Tasks.instrumented(AddBasicOrder.class, params);
    }
}
