package creaturesim.api;

import creaturesim.datastore.DynamoOperations;
import creaturesim.models.Creature;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("/creature")
@Produces(MediaType.APPLICATION_JSON)
public class CreatureEndpoint {

    private static DynamoOperations dynamo;

    public CreatureEndpoint(DynamoOperations dynamoOperations){
        dynamo = dynamoOperations;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public HashMap<String, String> createCreature(Creature requestBody){
        String creatureGUID = dynamo.CreateNewCreature(requestBody.creatureName, requestBody.creatorName, requestBody.strengthPoints,
                requestBody.attackPoints, requestBody.defencePoints, requestBody.speedPoints,
                null,null);
        if(creatureGUID != null){
            return new HashMap<>(){
                {
                    put("CreatureId", creatureGUID);
                }
            };
        }
        throw new WebApplicationException("Error Creating Creature", Response.Status.INTERNAL_SERVER_ERROR);
    }
}
