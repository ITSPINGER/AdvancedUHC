package net.pinger.uhc.events;

import net.pinger.uhc.AdvancedUHC;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerPreJoinEvent implements Listener {

    private final AdvancedUHC advancedUHC;

    public PlayerPreJoinEvent(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }

    @EventHandler
    public void onAsyncJoin(PlayerLoginEvent event) {
        if (!event.getPlayer().hasPermission("uhc.join") || !event.getPlayer().hasPermission("uhc.bypass.join")) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.RED + "You have no permission to join this lobby.");
        }
    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent event) {
        // Check for game states

        if (event.getLoginResult() == AsyncPlayerPreLoginEvent.Result.ALLOWED) {
            this.advancedUHC.getUserManager().createPlayer(event.getUniqueId());
        }
    }
}
