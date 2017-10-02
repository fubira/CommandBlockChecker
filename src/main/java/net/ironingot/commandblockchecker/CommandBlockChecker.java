package net.ironingot.commandblockchecker;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class CommandBlockChecker extends JavaPlugin {
    public static final Logger logger = Logger.getLogger("CommandBlockChecker");

    @Override
    public void onEnable() {
        new EventListeners(this);
        logger.info("CommandBlockChecker Enabled");
    }

    @Override
    public void onDisable() {
        logger.info("CommandBlockChecker Disabled");
    }
}
