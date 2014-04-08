package gr.stax.now;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import java.util.List;

/**
 * Created by antongravestam on 4/8/14.
 */
public class QueryResult {
    private List<DBObject> dbObjects;

    public QueryResult(List<DBObject> dbObjects) {
        this.dbObjects = dbObjects;
    }

    public String objectsAsString() {
        return JSON.serialize(dbObjects);
    }
}
