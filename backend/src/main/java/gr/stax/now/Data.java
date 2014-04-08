package gr.stax.now;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Created by antongravestam on 4/8/14.
 */

@Path("data")
@Singleton
public class Data {

    @GET
    @Path("insert/{type}")
    public String insert(@PathParam("type") String type, @QueryParam("jsonData") String jsonData) {

        String id = DbHelper.INSTANCE.insert(type, jsonData);

        return RelpyHelper.wrappedResult(id);
    }


    @GET
    @Path("get/{type}")
    public String get(@PathParam("type") String type, @QueryParam("id") String id) {

        ReadResult result = DbHelper.INSTANCE.getObject(type, id);

        return RelpyHelper.wrappedResult(result.objectAsString());
    }

    @GET
    @Path("query/{type}")
    public String query(@PathParam("type") String type, @QueryParam("query") String query) {

        QueryResult result = DbHelper.INSTANCE.getObjects(type, query);

        return RelpyHelper.wrappedResult(result);
    }


}
