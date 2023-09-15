package cl.mercadolibre.automationChallenge.screenplay.tasks;

import cl.mercadolibre.automationChallenge.screenplay.userinterface.WorldViewPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.jetbrains.annotations.NotNull;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWorldViewPageBrowser implements Task {
    @Override
    public <T extends Actor> void performAs(@NotNull T actor) {
        actor.attemptsTo(Open.browserOn(new WorldViewPage()));
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static OpenWorldViewPageBrowser on() {
        return instrumented(OpenWorldViewPageBrowser.class);
    }
}
