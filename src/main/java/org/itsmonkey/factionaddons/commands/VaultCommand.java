package org.itsmonkey.factionaddons.commands;

import com.massivecraft.factions.cmd.FCommand;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.itsmonkey.factionaddons.FactionAddons;
import org.itsmonkey.factionaddons.utils.StringUtils;

/**
 * Created by JMac on 11/19/15.
 */
public class VaultCommand extends FCommand {
    @Override
    public TL getUsageTranslation() {
        return null;
    }

    @Override
    public void perform() {

        if(args.size() == 1){

            Inventory inv = FactionAddons.getInstance().getFactionVault().get(fme.getFaction());
            me.openInventory(inv);
            me.setMetadata("opened", new FixedMetadataValue(FactionAddons.getInstance(), false));

        }

        if(args.size() == 2){
            if(!me.hasPermission("factionaddons.vaults.others")){
                msg(StringUtils.color("&cYou cannot see other factions' vaults!"));
            }
        }

    }
}
