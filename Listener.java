/*
 * Override methods from the StatusListener interface, a part of the Twitter4J
 * library. A stream object will call these methods and allow us to react to 
 * events. 
 */
package wfbot;

import twitter4j.StatusListener;
import twitter4j.StallWarning;
import twitter4j.StatusDeletionNotice;
import twitter4j.Status;
import java.io.File;
import java.util.Scanner;
/*
 * @author Ben
 */
public class Listener implements StatusListener{
    //Text file with keywords in it.
    File file;
    Scanner scanner;
    //Instance of my discord bot.
    DiscordBot dcbot;
    
    public Listener(){
        //Look for keywords file, close if not found
        file = new File("keywords.txt");
        if(!file.exists()){
            System.out.println("Keywords file missing. Shutting down.");
            System.exit(0);
        }
        
        //Init DiscordBot object
        dcbot=new DiscordBot();
    }
    
    @Override
    public void onStallWarning(StallWarning warning){System.out.println("Stall warning received: "+warning.getMessage());}
    
    @Override
    public void onScrubGeo(long userId, long upToStatusId){System.out.println("Scrub geo warning received: "+userId+", "+upToStatusId);}
    
    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses){System.out.println("Track limit notice received: "+numberOfLimitedStatuses);}
    
    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice){System.out.println("Deletion notice received: "+statusDeletionNotice);}
    
    @Override
    public void onStatus(Status status){
        //Upon receiving a status from twitter:
        String line="";
        boolean found=false;
        try{
            //First reset the scanner
            scanner=new Scanner(file);
        }catch(Exception e){
            System.out.println("Scanner failed to init, file not found. Shutting down.");
            System.exit(0);
        }
        
        System.out.println("Status posted from user"+status.getUser().getId()+": "+status.getText());
        
        //Loop through keywords.txt and compare against the most recent tweet.
        while(scanner.hasNext()&&!found){
            line=scanner.nextLine();
            /*
             * If a keyword is found, exit loop and send tweet to discord server.
             * Make sure grabbed tweets are by warframealerts instead of about 
             * warframealerts by comparing the id of the user to warframealerts'
             * id.
             */
            if(status.getText().toLowerCase().contains(line.toLowerCase()) && status.getUser().getId()==(long)1344755923){
                System.out.println("Specified keyword tweeted");
                found=true;
                dcbot.sendMessage(status.getText());
            }
        }
        
    }
    
    @Override
    public void onException(java.lang.Exception ex){System.out.println("Exception: "+ex.getMessage());}
}
