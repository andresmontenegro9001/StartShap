package co.com.choucair.automation.startshap.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://serenity.is/demo/Account/Login/")
public class LoginPage extends PageObject {

    public static final Target USERNAME = Target.the("Username to login").located(By.id("StartSharp_Membership_LoginPanel0_Username"));
    public static final Target PASSWORD = Target.the("Password to login").located(By.id("StartSharp_Membership_LoginPanel0_Password"));
    public static final Target BUTTON_SIGN_IN = Target.the("Password to login").located(By.id("StartSharp_Membership_LoginPanel0_LoginButton"));

}
