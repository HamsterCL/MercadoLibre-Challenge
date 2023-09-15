package cl.mercadolibre.automationChallenge.screenplay.tasks;

import cl.mercadolibre.automationChallenge.screenplay.userinterface.ElementPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillFormAgeInput implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(String.valueOf(age)).into(ElementPage.AGE).thenHit(Keys.TAB));
    }
    private final Integer age;

    public FillFormAgeInput(Integer age) {
        this.age = age;
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static FillFormAgeInput fillInputAge(Integer age) {
        return instrumented(FillFormAgeInput.class, age);
    }
}
