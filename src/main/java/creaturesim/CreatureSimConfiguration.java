package creaturesim;


import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class CreatureSimConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate(){
        return template;
    }

    @JsonProperty
    public void setTemplate(String template){
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName(){
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName){
        this.defaultName = defaultName;
    }
}
