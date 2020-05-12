package creaturesim;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import creaturesim.api.HelloWorld;
import creaturesim.healthchecks.TemplateHealthCheck;

public class CreatureSimApplication extends Application<CreatureSimConfiguration> {

    public static void main(String[] args) throws Exception {
        new CreatureSimApplication().run(args);
    }

    @Override
    public String getName() {
        return "Raymond's Hello World";
    }

    @Override
    public void initialize(Bootstrap<CreatureSimConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(CreatureSimConfiguration configuration, Environment environment) throws Exception {
        final HelloWorld resource = new HelloWorld(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.jersey().register(resource);
        environment.healthChecks().register("template", healthCheck);
    }
}
