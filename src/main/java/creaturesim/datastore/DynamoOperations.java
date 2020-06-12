package creaturesim.datastore;

import org.joda.time.Instant;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DynamoOperations {

    private static DynamoDbClient client;
    private static final String creatureTableName = "Creatures";

    public DynamoOperations(String dynamoHost, String dynamoRegion){
        URI hostURI = URI.create(dynamoHost);
        client = DynamoDbClient.builder().region(selectRegion(dynamoRegion)).endpointOverride(hostURI).build();
        initDB();
    }

    private void initDB(){
        try {
            ListTablesResponse listTablesResponse = client.listTables();
            List<String> tableNames = listTablesResponse.tableNames();
            if(!tableNames.contains(creatureTableName)) {
                createTable();
            }
        }
        catch (DynamoDbException | SdkClientException e){
            System.err.println(String.format("Could not get table names: %s", e.getMessage()));
            System.exit(1);
        }
    }

    private void createTable(){
        CreateTableRequest request = CreateTableRequest.builder()
                .attributeDefinitions(
                        AttributeDefinition.builder()
                                .attributeName("CreatureId")
                                .attributeType(ScalarAttributeType.S)
                                .build()
                        )
                .keySchema(KeySchemaElement.builder()
                        .attributeName("CreatureId")
                        .keyType(KeyType.HASH)
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(10L)
                        .writeCapacityUnits(10L)
                        .build())
                .tableName(creatureTableName)
                .build();
        try{
            CreateTableResponse response = client.createTable(request);
            String returnedName = response.tableDescription().tableName();
            if(returnedName == null || returnedName.isEmpty())
            {
                throw new Exception("Could not create table, response returned empty name.");
            }
        }
        catch (Exception e) {
            System.err.println(String.format("Could not create table: %s", e.getMessage()));
            System.exit(1);
        }
    }

    public String CreateNewCreature(String creatureName, String creatorName, int strength, int attack, int defence,
                            int speed, String parentOneGUID, String parentTwoGUID){

        String creatureGUID = UUID.randomUUID().toString();

        HashMap<String, AttributeValue> itemValues = new HashMap<>();
        itemValues.put("CreatureId", AttributeValue.builder().s(creatureGUID).build());
        itemValues.put("CreatureName", AttributeValue.builder().s(creatureName).build());
        itemValues.put("CreatorName", AttributeValue.builder().s(creatorName).build());
        itemValues.put("Strength", AttributeValue.builder().n(String.valueOf(strength)).build());
        itemValues.put("Attack", AttributeValue.builder().n(String.valueOf(attack)).build());
        itemValues.put("Defence", AttributeValue.builder().n(String.valueOf(defence)).build());
        itemValues.put("Speed", AttributeValue.builder().n(String.valueOf(speed)).build());
        itemValues.put("Created", AttributeValue.builder().n(String.valueOf(Instant.now().getMillis())).build());

        if(parentOneGUID != null && parentTwoGUID != null) {
            itemValues.put("ParentOne", AttributeValue.builder().s(parentOneGUID).build());
            itemValues.put("ParentTwo", AttributeValue.builder().s(parentTwoGUID).build());
        }
        itemValues.put("Timeline", AttributeValue.builder().l(
                AttributeValue.builder().m(
                        new HashMap<>(){{
                            put(String.valueOf(Instant.now().getMillis()),AttributeValue.builder().s("Born").build());
                        }}
                ).build()
        ).build());


        PutItemRequest request = PutItemRequest.builder()
                .tableName(creatureTableName)
                .item(itemValues)
                .build();

        try {
            client.putItem(request);
            return creatureGUID;
        }
        catch (DynamoDbException e)
        {
            System.err.println(String.format("Could not create item: %s", e.getMessage()));
            return null;
        }
    }

    private Region selectRegion(String region){
        if(region.equalsIgnoreCase("eu-west-1")){
            return Region.EU_WEST_1;
        }else {
            return Region.US_EAST_2;
        }
    }
}
