package me.apollo.democracy;

import me.apollo.democracy.commands.ElectionCommand;
import me.apollo.democracy.utils.Election;
import org.bukkit.plugin.java.JavaPlugin;

public final class Democracy extends JavaPlugin {

    public Election election = new Election();

    private static Democracy plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("election").setExecutor(new ElectionCommand());
    }

    public static Democracy getPlugin() {
        return plugin;
    }
}
