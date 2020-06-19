package creaturesim.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class World {

    @JsonProperty
    public ArrayList<HashMap<String,Object>> world;

    public World(TerrainMap map){
        world = new ArrayList<>();
        buildSelf(map);
    }

    private void buildSelf(TerrainMap map){
        int rowNumber = 1;
        for (ArrayList mapRow : map.getMap()) {
            HashMap<String,Object> row = new HashMap<>();
            row.put("terrain", addKeysToCells(mapRow, rowNumber));
            world.add(row);
            rowNumber++;
        }
    }

    private ArrayList<HashMap<String, String>> addKeysToCells(ArrayList<String> mapRow, int rowNumber){
        ArrayList<HashMap<String, String>> row = new ArrayList<>();
        int counter = (10 * rowNumber) - 9;
        for(String mapCell : mapRow){
            HashMap<String,String> cell = new HashMap<>();
            cell.put("key", String.valueOf(counter));
            cell.put("type", mapCell);
            row.add(cell);
            counter++;
        }
        return row;
    }

}
