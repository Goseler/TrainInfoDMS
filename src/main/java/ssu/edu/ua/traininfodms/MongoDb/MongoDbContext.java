package ssu.edu.ua.traininfodms.MongoDb;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.Shared.Seats;
import ssu.edu.ua.traininfodms.Models.Mapper;

public class MongoDbContext {
    private final static String connectionString = "mongodb://localhost:27017";
    private final static String databaseName = "trainDMS";
    private final static String collectionName = "trains";

    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;
    private static MongoCollection trainCollection = null;

    public static void Connect() {
        try {
            mongoClient = MongoClients.create(connectionString);
            database = mongoClient.getDatabase(databaseName);
            trainCollection = database.getCollection(collectionName);

            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Connected successfully to server.");
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MongoCollection<Document> getCollection() {
        return database.getCollection(collectionName);
    }

    public static void Disconnect() {
        mongoClient.close();
        System.out.println("Disconnected successfully");
    }
}
