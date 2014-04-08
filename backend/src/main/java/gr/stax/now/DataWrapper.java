package gr.stax.now;

/**
 * Created by antongravestam on 4/7/14.
 */
public class DataWrapper {

    private Meta meta = Meta.INSTANCE;
    private Object data;

    public DataWrapper(Object data) {
        this.data = data;
    }
}
