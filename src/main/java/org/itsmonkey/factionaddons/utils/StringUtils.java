package org.itsmonkey.factionaddons.utils;

import org.bukkit.ChatColor;

/**
 * Created by Julio on 11/10/2015.
 */
public class StringUtils {

    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
