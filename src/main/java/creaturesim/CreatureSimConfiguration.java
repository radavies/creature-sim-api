package creaturesim;


import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class CreatureSimConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String dynamoHost = "http://localhost:8000";

    @NotEmpty
    private String dynamoRegion = "us-west-2";

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

    @JsonProperty
    public String getDynamoHost(){
        return dynamoHost;
    }

    @JsonProperty
    public void setDynamoHost(String dynamoHost){
        this.dynamoHost = dynamoHost;
    }

    @JsonProperty
    public String getDynamoRegion(){
        return dynamoRegion;
    }

    @JsonProperty
    public void setDynamoRegion(String dynamoRegion){
        this.dynamoRegion = dynamoRegion;
    }
}
