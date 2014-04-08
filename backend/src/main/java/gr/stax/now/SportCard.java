package gr.stax.now;

import org.mongojack.ObjectId;

/**
 * Created by antongravestam on 4/7/14.
 */
public class SportCard {


    public String _id;
    private String homeTeam;
    private String guestTeam;
    private long timeToKickOff;

    public SportCard() {

    }

    public SportCard(String homeTeam, String guestTeam, long timeToKickOff) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.timeToKickOff = timeToKickOff;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public long getTimeToKickOff() {
        return timeToKickOff;
    }

}
