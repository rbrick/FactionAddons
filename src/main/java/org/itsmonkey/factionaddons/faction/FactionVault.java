package org.itsmonkey.factionaddons.faction;

import com.massivecraft.factions.Faction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by JMac on 11/19/15.
 */
public class FactionVault {

    public Inventory get(Faction faction){
        //TODO: Actually make this a real inventory
        return Bukkit.createInventory(null, 9, faction.getTag() + "'s Vault");
    }

    public boolean inInventory(Player player){
        return player.hasMetadata("opened");
    }

}
