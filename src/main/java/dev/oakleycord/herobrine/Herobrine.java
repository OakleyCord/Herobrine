package dev.oakleycord.herobrine;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Herobrine extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCommand command = getCommand("herobrine");
        if(command == null) {
            getLogger().warning("Failed to load command.");
            return;
        }
        command.setExecutor(new HerobrineCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
