package org.itsmonkey.factionaddons;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.itsmonkey.factionaddons.commands.CommandHandler;
import org.itsmonkey.factionaddons.faction.FactionManager;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Julio on 11/10/2015.
 */
public class FactionAddons extends JavaPlugin {

    public HashMap<UUID, Boolean> inFly = new HashMap<UUID, Boolean>();


    private static FactionAddons instance;
    private FactionManager factionManager;

    public void onEnable(){
        instance = this;
        factionManager = new FactionManager();

        Bukkit.getPluginManager().registerEvents(new CommandHandler(), this);
    }

    public static FactionAddons getInstance(){
        return instance;
    }

    public FactionManager getFactionManager(){
        return factionManager;
    }


}
