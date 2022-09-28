package co.com.choucair.automation.startshap.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.automation.startshap.userinterface.DashboardPage.DASHBOARD_TITLE;
import static co.com.choucair.automation.startshap.userinterface.DashboardPage.ORDERS_TITLE;

public class ReviewData {

    private ReviewData() {
        throw new IllegalStateException("ReviewData class");
    }

    public static Question<String> dashboardTitle(){
        return actor -> Text.of(DASHBOARD_TITLE).viewedBy(actor).asString();
    }

    public static Question<String> ordersTitle(){
        return actor -> Text.of(ORDERS_TITLE).viewedBy(actor).asString();
    }
}
