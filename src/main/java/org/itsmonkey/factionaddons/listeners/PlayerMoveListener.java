package org.itsmonkey.factionaddons.listeners;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.itsmonkey.factionaddons.FactionAddons;

/**
 * Created by JMac on 11/19/15.
 */
public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerFly(PlayerMoveEvent event){
        Player player = event.getPlayer();
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);
        if(FactionAddons.getInstance().inFly.get(player.getUniqueId())){
            //Is in fly mode
            //Check if they move to territory which does not belong to them
        }
    }

}
