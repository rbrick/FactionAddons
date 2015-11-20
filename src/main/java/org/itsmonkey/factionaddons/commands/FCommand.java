package org.itsmonkey.factionaddons.commands;

import org.bukkit.entity.Player;

/**
 * Created by Julio on 11/10/2015.
 */
public abstract class FCommand {

    public abstract void execute(Player player, String[] args);

    private String command;
    private String[] aliases;

    public FCommand(String command, String[] aliases) {
        this.command = command;
        this.aliases = aliases;
    }

    public String getCommand() {
        return command;
    }

    public String[] getAliases() {
        return aliases;
    }
}
