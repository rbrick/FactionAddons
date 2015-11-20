package org.itsmonkey.factionaddons.commands;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Role;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.itsmonkey.factionaddons.FactionAddons;
import org.itsmonkey.factionaddons.utils.FileUtils;
import org.itsmonkey.factionaddons.utils.StringUtils;

import java.io.File;

/**
 * Created by Julio on 11/10/2015.
 */
public class FriendlyFireCommand extends FCommand {

    public FriendlyFireCommand(){
        super("friendlyfire", new String[]{"ff"});
    }

    @Override
    public void execute(Player player, String[] args) {
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);

        if(args.length == 1){

            if(fPlayer.getFaction() == null){
                player.sendMessage(StringUtils.color("&cYou do not have a faction!"));
                return;
            }

            if(fPlayer.getRole() != Role.MODERATOR && fPlayer.getRole() != Role.ADMIN){
                player.sendMessage(StringUtils.color("&cYou must be a faction moderator or above to use this command!"));
                return;
            }

            player.sendMessage(StringUtils.color("&cUsage: /f friendlyfire on|off"));
            return;
        }

        if(args.length == 2){

            String option = args[1];

            File file = FactionAddons.getInstance().getFactionManager().getFactionFile(player, fPlayer.getFaction().getId());
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            if(option.equalsIgnoreCase("on")){
                config.set("FriendlyFire", true);
                FileUtils.save(config, file);
                for(FPlayer fPlayers : fPlayer.getFaction().getFPlayers()){
                    fPlayers.getPlayer().sendMessage(StringUtils.color("&e" + player.getName() + " &fenabled friendly fire"));
                }
                return;
            }

            if(option.equalsIgnoreCase("off")){
                config.set("FriendlyFire", false);
                FileUtils.save(config, file);
                for(FPlayer fPlayers : fPlayer.getFaction().getFPlayers()){
                    fPlayers.getPlayer().sendMessage(StringUtils.color("&e" + player.getName() + " &fdisabled friendly fire"));
                }
                return;
            }

            player.sendMessage(StringUtils.color("&cUsage: /f friendlyfire on|off"));
        }

    }
}
