package gr.stax.now;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.mongojack.DBQuery;

import java.net.UnknownHostException;

/**
 * Created by antongravestam on 4/8/14.
 */
public enum DbHelper {
    INSTANCE;


    private final DB db;

    DbHelper () {

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            throw new RuntimeException("", e);
        }
        db = mongoClient.getDB("cards");

    }

    public String insert(String type, String jsonData) {

        DBObject dbObject = (DBObject) JSON.parse(jsonData);
        db.getCollectionFromString(type).insert(dbObject);
        ObjectId id = (ObjectId)dbObject.get("_id");
        return id.toStringMongod();
    }

    public ReadResult getObject(String type, String id) {

        DBObject dbObject = db.getCollectionFromString(type).findOne(new ObjectId(id));
        return new ReadResult(dbObject);

    }

    public QueryResult getObjects(String type, String query) {
        DBCursor dbCursor = db.getCollectionFromString(type).find((DBObject) JSON.parse(query));
        return new QueryResult(dbCursor.toArray());
    }
}
