package cl.mercadolibre.automationChallenge.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ElementPage {

    public static Target FIRST_NAME = Target.the("firstName").located(By.id("first_name"));
    public static final Target LAST_NAME = Target.the("lastName").located(By.id("last_name"));
    public static final Target AGE = Target.the("age").located(By.id("age"));
    public static final Target COUNTRY = Target.the("country").located(By.id("country"));
    public static final Target CREATE_BUTTON = Target.the("create button").locatedBy("//button[@type='submit']");

}
