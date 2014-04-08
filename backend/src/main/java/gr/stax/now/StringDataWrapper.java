package gr.stax.now;

import com.google.gson.JsonElement;

/**
 * Created by antongravestam on 4/8/14.
 */
public class StringDataWrapper {
    private Meta meta = Meta.INSTANCE;
    private String data;

    public StringDataWrapper(String objectsAsString) {
        this.data = objectsAsString;
    }
}
