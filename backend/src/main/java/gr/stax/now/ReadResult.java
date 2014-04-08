package gr.stax.now;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.bson.BSON;

/**
 * Created by antongravestam on 4/8/14.
 */
public class ReadResult {
    private DBObject dbObject;

    public ReadResult(DBObject dbObject) {

        this.dbObject = dbObject;
    }

    public String objectAsString() {
        return JSON.serialize(dbObject);
    }
}
