package cl.mercadolibre.automationChallenge.screenplay.tasks;

import cl.mercadolibre.automationChallenge.screenplay.userinterface.CreatePersonPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenBrowser implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(new CreatePersonPage()));

    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static OpenBrowser on() {

        return instrumented(OpenBrowser.class);
    }
}
