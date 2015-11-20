package org.itsmonkey.factionaddons;

import com.massivecraft.factions.P;
import org.bukkit.plugin.java.JavaPlugin;
import org.itsmonkey.factionaddons.commands.FlyCommand;
import org.itsmonkey.factionaddons.commands.FriendlyFireCommand;
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

        // Register our commands!!
        {
            P.p.cmdBase.addSubCommand(new FriendlyFireCommand());
            P.p.cmdBase.addSubCommand(new FlyCommand());
        }

    }

    public static FactionAddons getInstance(){
        return instance;
    }

    public FactionManager getFactionManager(){
        return factionManager;
    }


}
