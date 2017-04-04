import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;


/**
 * Created by felixhoffmann on 26.03.17.
 */
public class App extends Application<AppConfiguration> {
    public static void main(String[] args) {

    }

    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        GuiceBundle<AppConfiguration> guiceBundle = GuiceBundle.<AppConfiguration>newBuilder()
                .addModule(new App())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(AppConfiguration.class)
                .setInjectorFactory((stage,modules) -> LifecycleInjector.builder()
                .inStage(stage)
                .withModules(modules)
                .build()
                .createInjector())
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        //

    }
}
