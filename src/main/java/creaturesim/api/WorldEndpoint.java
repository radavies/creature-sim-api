package creaturesim.api;

import creaturesim.models.TerrainMap;
import creaturesim.models.World;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/world")
@Produces(MediaType.APPLICATION_JSON)
public class WorldEndpoint {

    private static TerrainMap terrainMap;

    public WorldEndpoint(TerrainMap theTerrainMap){
        terrainMap = theTerrainMap;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public World getWorld(){
        World world = new World(terrainMap);
        return world;
    }
}
