package org.itsmonkey.factionaddons.commands;

import com.massivecraft.factions.cmd.FCommand;
import com.massivecraft.factions.zcore.util.TL;
import org.itsmonkey.factionaddons.FactionAddons;
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

        if(myFaction == null){
            msg(StringUtils.color("&cYou need to be part of a faction to perform this command!"));
            return;
        }

        if(!fme.isInOwnTerritory()){
            msg(StringUtils.color("&cYou must be at your own territory to use this command!"));
            return;
        }

        if(!FactionAddons.getInstance().inFly.containsKey(me.getUniqueId())){
            FactionAddons.getInstance().inFly.put(me.getUniqueId(), false);
        }

        if(FactionAddons.getInstance().inFly.get(me.getUniqueId())){
            FactionAddons.getInstance().inFly.put(me.getUniqueId(), false);
            msg(StringUtils.color("&aYou have de-activated fly mode!"));
        } else {
            FactionAddons.getInstance().inFly.put(me.getUniqueId(), true);
            msg(StringUtils.color("&aYou have activated fly mode!\n You can now fly in your own faction territory"));
        }


    }
}
