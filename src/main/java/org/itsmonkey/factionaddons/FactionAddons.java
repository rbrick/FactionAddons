package org.itsmonkey.factionaddons;

import com.massivecraft.factions.P;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.itsmonkey.factionaddons.commands.FlyCommand;
import org.itsmonkey.factionaddons.commands.FriendlyFireCommand;
import org.itsmonkey.factionaddons.commands.VaultCommand;
import org.itsmonkey.factionaddons.faction.FactionManager;
import org.itsmonkey.factionaddons.faction.FactionVault;
import org.itsmonkey.factionaddons.listeners.PlayerDeathListener;
import org.itsmonkey.factionaddons.listeners.PlayerInventoryListener;
import org.itsmonkey.factionaddons.listeners.PlayerMoveListener;

/**
 * Created by Julio on 11/10/2015.
 */
public class FactionAddons extends JavaPlugin {

    // Lombok!!
    @Getter private static FactionAddons instance;
    @Getter private FactionManager factionManager;
    @Getter private FactionVault factionVault;

    @Override
    public void onEnable(){
        instance = this;
        this.factionManager = new FactionManager();
        this.factionVault = new FactionVault();

        // Register our commands!!
        {
            P.p.cmdBase.addSubCommand(new FriendlyFireCommand());
            P.p.cmdBase.addSubCommand(new FlyCommand());
            P.p.cmdBase.addSubCommand(new VaultCommand());
        }

        // Register our listeners!!
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerDeathListener(), this);
        pm.registerEvents(new PlayerInventoryListener(), this);
        pm.registerEvents(new PlayerMoveListener(), this);

    }


}
