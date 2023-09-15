package cl.mercadolibre.automationChallenge.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickSubmitButton implements Task {

    private final Target submitButton;

    public ClickSubmitButton(Target submitButton) {
        this.submitButton = submitButton;
    }

    public static ClickSubmitButton called(Target submitButton) {
        return instrumented(ClickSubmitButton.class, submitButton);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(submitButton)
        );
    }
}
