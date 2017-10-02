package net.ironingot.commandblockchecker;

import org.bukkit.Material;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Logger;

public class EventListeners implements Listener
{
    private CommandBlockChecker plugin;

    public EventListeners(CommandBlockChecker plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(final PlayerInteractEvent event)
    {
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if (event.getClickedBlock().getType() == Material.COMMAND ||
                event.getClickedBlock().getType() == Material.COMMAND_CHAIN ||
                event.getClickedBlock().getType() == Material.COMMAND_REPEATING ||
                event.getClickedBlock().getType() == Material.COMMAND_MINECART)
            {
                Player player = event.getPlayer();
                CommandBlock block = (CommandBlock)event.getClickedBlock().getState();
                String name = block.getName();
                String command = block.getCommand();

                String output = "" + name + "(" + event.getClickedBlock().getType() + "):'" + command + "'";
                player.sendMessage((new StringBuilder())
                    .append(ChatColor.GOLD).append("[CBChecker] ")
                    .append(ChatColor.RESET).append(output)
                    .toString());

                CommandBlockChecker.logger.info("[CBChecker] " + player.getName() + " clicked CommandBlock: " + output);
            }
        }
    }
}
