package cl.mercadolibre.automationChallenge.screenplay.tasks;

import cl.mercadolibre.automationChallenge.screenplay.userinterface.ElementPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillFormLastNameInput implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(lastName).into(ElementPage.LAST_NAME).thenHit(Keys.TAB));
    }
    private final String lastName;

    public FillFormLastNameInput(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static FillFormLastNameInput fillInputLastName(String lastName) {
        return instrumented(FillFormLastNameInput.class, lastName);
    }
}
