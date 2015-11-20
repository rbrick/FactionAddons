package org.itsmonkey.factionaddons.listeners;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Role;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.itsmonkey.factionaddons.FactionAddons;
import org.itsmonkey.factionaddons.utils.StringUtils;

/**
 * Created by JMac on 11/19/15.
 */
public class PlayerInventoryListener implements Listener {

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);
        if(FactionAddons.getInstance().getFactionVault().inInventory(player)){
            if(fPlayer.getRole() != Role.MODERATOR && fPlayer.getRole() != Role.ADMIN){
                player.sendMessage(StringUtils.color("&cOnly faction moderators and admins can edit the vault!"));
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        if(player.hasMetadata("opened")){
            player.removeMetadata("opened", FactionAddons.getInstance());
        }
    }

}
