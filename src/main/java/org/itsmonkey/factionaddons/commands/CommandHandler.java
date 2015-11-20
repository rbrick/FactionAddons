package org.itsmonkey.factionaddons.commands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

/**
 * Created by Julio on 11/10/2015.
 */
@Deprecated
public class CommandHandler implements Listener {

    private ArrayList<DeprecatedFCommand> commands = new ArrayList<DeprecatedFCommand>();

    public CommandHandler(){
    //    commands.add(new FriendlyFireCommand());
    }

    @EventHandler
    public void onFactionCommand(PlayerCommandPreprocessEvent event){
        String[] args = event.getMessage().split(" ");

        if(!args[0].equalsIgnoreCase("/f")) return;

        for(DeprecatedFCommand command : commands){

            if(args[1].equalsIgnoreCase(command.getCommand())){
                event.setCancelled(true);
                command.execute(event.getPlayer(), args);
            }

            //TODO: Make a better system for aliases :c
            for(String alias : command.getAliases()){
                if(args[1].equalsIgnoreCase(alias)){
                    event.setCancelled(true);
                    command.execute(event.getPlayer(), args);
                }
            }

        }

    }

}
