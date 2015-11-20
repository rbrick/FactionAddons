package org.itsmonkey.factionaddons.faction;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Created by Julio on 11/10/2015.
 */
public class FactionManager {

    public File getFactionFile(Player player, String factionId){
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);

        return fPlayer.getFaction() == null ?
                null : new File("plugins/FactionAddons/Factions/" + factionId + ".yml");
    }



    public void setFriendlyFire(boolean friendlyFire){

        if(friendlyFire){

        }

    }

}
