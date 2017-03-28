/*
 * Discord bot class built with Discord4J.
 */

package wfbot;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.MessageBuilder;
/*
 * @author Ben
 */
public class DiscordBot {
    ClientBuilder builder;
    IDiscordClient client;
    MessageBuilder messager;
    public DiscordBot(){
        //Authenticate with token from discord dev site
        builder = new ClientBuilder();
        builder.withToken("<TOKEN HERE>");
        try{
            client=builder.login();
            System.out.println("Discord login successful");
        }catch(Exception e){
            System.out.println("Discord ERR: "+e.getMessage());
        }
        
    }
    
    public void sendMessage(String text){
        try{
            //Send message to my warframe channel
            new MessageBuilder(client).withChannel("<CHANNEL ID>").withContent(text).build();
        }catch(Exception e){
            System.out.println("Discord ERR: "+e.getMessage());
        }
        
    }
    
}
