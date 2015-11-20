package org.itsmonkey.factionaddons.commands;

import com.massivecraft.factions.cmd.FCommand;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.GameMode;
import org.itsmonkey.factionaddons.utils.StringUtils;

/**
 * Created by JMac on 11/19/15.
 */
public class FlyCommand extends FCommand {
    @Override
    public TL getUsageTranslation() {
        return null;
    }

    @Override
    public void perform() {

        if(args.size() != 1){
            me.sendMessage(StringUtils.color("&cUsage: /f fly"));
            return;
        }

        if(myFaction == null){
            msg(StringUtils.color("&cYou need to be part of a faction to perform this command!"));
            return;
        }

        if(!fme.isInOwnTerritory()){
            msg(StringUtils.color("&cYou must be at your own territory to use this command!"));
            return;
        }

        if(me.isFlying() && me.getGameMode() != GameMode.CREATIVE){
            msg(StringUtils.color("&aYou have de-activated fly mode!"));
            me.setFlying(false);
            me.setAllowFlight(false);
        } else {
            msg(StringUtils.color("&aYou have activated fly mode!\n You can now fly in your own faction territory"));
            me.setAllowFlight(true);
            me.setFlying(true);
        }


    }
}
