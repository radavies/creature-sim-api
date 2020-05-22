package creaturesim;

import creaturesim.api.CreatureEndpoint;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import creaturesim.api.HelloWorld;
import creaturesim.healthchecks.TemplateHealthCheck;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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

        //Set Up for CORS
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());

        final HelloWorld resource = new HelloWorld(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final CreatureEndpoint creatureEndpoint = new CreatureEndpoint();
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.jersey().register(resource);
        environment.jersey().register(creatureEndpoint);
        environment.healthChecks().register("template", healthCheck);
    }
}
