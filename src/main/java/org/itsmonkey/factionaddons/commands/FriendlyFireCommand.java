package org.itsmonkey.factionaddons.commands;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.cmd.FCommand;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.configuration.file.YamlConfiguration;
import org.itsmonkey.factionaddons.FactionAddons;
import org.itsmonkey.factionaddons.utils.FileUtils;
import org.itsmonkey.factionaddons.utils.StringUtils;

import java.io.File;

/**
 * Created by Julio on 11/10/2015.
 */
public class FriendlyFireCommand extends FCommand {

    @Override
    public TL getUsageTranslation() {
        return null;
    }

    @Override
    public void perform() {

        if(myFaction == null) {
            msg(StringUtils.color("&cYou do not have a faction!"));
            return;
        }

        if(fme.getRole() != Role.MODERATOR && fme.getRole() != Role.ADMIN){
            msg(StringUtils.color(
                "&cYou must be a faction moderator or above to use this command!"));
            return;
        }


        if(args.size() == 1){
            msg(StringUtils.color("&cUsage: /f friendlyfire on|off"));
        } else if(args.size() == 2){

            String option = argAsString(1);

            File file = FactionAddons.getInstance().getFactionManager().getFactionFile(me, myFaction.getId());
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            if(option.equalsIgnoreCase("on")){
                config.set("FriendlyFire", true);
                FileUtils.save(config, file);
                for(FPlayer fPlayers : myFaction.getFPlayers()){
                    fPlayers.getPlayer().sendMessage(StringUtils.color("&e" + me.getName() + " &fenabled friendly fire"));
                }
                return;
            }

            if(option.equalsIgnoreCase("off")){
                config.set("FriendlyFire", false);
                FileUtils.save(config, file);
                for(FPlayer fPlayers : myFaction.getFPlayers()){
                    fPlayers.getPlayer().sendMessage(StringUtils.color("&e" + me.getName() + " &wfdisabled friendly fire"));
                }
                return;
            }

            msg(StringUtils.color("&cUsage: /f friendlyfire on|off"));
        }
    }
}
