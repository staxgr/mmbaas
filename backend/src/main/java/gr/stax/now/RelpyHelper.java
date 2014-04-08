package gr.stax.now;

import com.google.gson.Gson;
import com.mongodb.WriteResult;

/**
 * Created by antongravestam on 4/8/14.
 */
public class RelpyHelper {
    public static String wrappedResult(String objectId) {

        InsertResult insertResult = new InsertResult(objectId);
        return new Gson().toJson(insertResult);
    }

    public static String wrappedResult(QueryResult result) {

        return new Gson().toJson(new StringDataWrapper(result.objectsAsString()));
    }
}
