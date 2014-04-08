package gr.stax.now;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.sun.jersey.spi.resource.Singleton;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.DBSort;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

@Path("cards")
@Singleton
public class Cards {

    private final DB db;

    public Cards () throws UnknownHostException {
        System.out.println("Cards.Cards");

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        db = mongoClient.getDB("cards");


    }

    @GET
    @Path("supported")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSupported() {

        CardType[] cardTypes = Arrays.asList(
                new CardType("weather"),
                new CardType(("sport"))
        ).toArray(new CardType[2]);

        return wrapped(cardTypes);

    }

    @GET
    @Path("sportcreate")
    @Produces(MediaType.TEXT_PLAIN)
    public String createSportCard(@QueryParam("home")String homeTeam, @QueryParam("guests")String guestTeam, @QueryParam("kickoff") long kickoff) {

        SportCard sportCard = new SportCard(homeTeam, guestTeam, System.currentTimeMillis() + kickoff);

        WriteResult<SportCard, String> writeResult = getSportCollection().insert(sportCard);

        return "done";

    }

    @GET
    @Path("sport")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSport(@QueryParam("team")String teamId) {

        DBCursor<SportCard> cards = getSportCollection().find()
                .and(
                        DBQuery.
                                greaterThan("timeToKickOff", System.currentTimeMillis()),
                        DBQuery
                                .or(DBQuery
                                    .is("homeTeam", teamId), DBQuery
                                    .is("guestTeam", teamId)))
                .sort(DBSort.asc("timeToKickOff"));

        return wrapped(cards.toArray());
    }

    private JacksonDBCollection<SportCard, String> getSportCollection() {
        JacksonDBCollection<SportCard, String> coll = JacksonDBCollection.wrap(db.getCollection("sport"), SportCard.class,
                String.class);
        return coll;
    }

    private String wrapped(Object data) {
        return new Gson().toJson(new DataWrapper(data));
    }

}