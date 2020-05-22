package creaturesim.api;

import creaturesim.models.Creature;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/creature")
@Produces(MediaType.APPLICATION_JSON)
public class CreatureEndpoint {
    public CreatureEndpoint(){
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int createCreature(Creature requestBody){
        return 1;
    }
}
