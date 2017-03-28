/*
 * Warframe bot to scan @WarframeAlerts and send missions with interesting 
 * rewards to a discord server. 
 * Uses Twitter4J and Discord4J apis. 
 */

package wfbot;
import twitter4j.conf.*;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.FilterQuery;

/*
 * @author Ben
 */
public class WFbot {

    public static void main(String[] args) {
        //Log in as your twitter bot. Must have created one through dev site. 
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        
        //Get these from twitter dev site
        cb.setOAuthConsumerKey("");
        cb.setOAuthAccessTokenSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthConsumerSecret("");
        
        //Create listener and stream object
        Listener listener=new Listener();
        TwitterStream stream=new TwitterStreamFactory(cb.build()).getInstance();
        stream.addListener(listener);
        
        /*
         * Watch tweets that are related to @WarframeAlerts. 
         * The number is their twitter's ID. This grabs any tweet that is related
         * to this twitter account, including retweets. 
         */
        stream.filter(new FilterQuery((long)1344755923));
        
        /*
         * Twitter stream api is what I want to use here. Grabs tweets in real time,
         * which I need, as alert missions are time-sensitive. 
         * Stream requires a listener, just a class you create that inherits an interface.
         */
    }
    
}
