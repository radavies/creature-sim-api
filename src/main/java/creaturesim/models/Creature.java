package creaturesim.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Creature {
    @JsonProperty
    public String creatureName;
    @JsonProperty
    public String creatorName;
    @JsonProperty
    public int strengthPoints;
    @JsonProperty
    public int attackPoints;
    @JsonProperty
    public int defencePoints;
    @JsonProperty
    public int speedPoints;

    public Creature(){

    }
}
