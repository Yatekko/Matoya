import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.File;

public class Matoya extends ListenerAdapter
{
    private static EventWaiter eventWaiter;

    public static void main(String[] args) throws LoginException
    {
        Config conf = ConfigFactory.parseFile(new File("Matoya.conf"));
        eventWaiter = new EventWaiter();

        CommandClientBuilder commandClientBuilder = new CommandClientBuilder()
                .setPrefix("!")
                .setOwnerId(conf.getString("Matoya.owner"))
                .setActivity(Activity.playing("!help for commands"))
                .addCommands(
                        // Owner

                        // General

                );
        CommandClient commandClient = commandClientBuilder.build();

        JDA jda = JDABuilder.createDefault(conf.getString("Matoya.token")).addEventListeners(commandClient, eventWaiter).build();
    }
}