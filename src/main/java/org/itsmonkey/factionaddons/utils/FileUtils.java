package org.itsmonkey.factionaddons.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Julio on 11/10/2015.
 */
public class FileUtils {

    public static void save(YamlConfiguration config, File file){
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
