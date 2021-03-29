package net.pinger.uhc.provider;

import me.missionary.board.provider.BoardProvider;
import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.game.state.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;

public class ScoreboardProviderImplementation implements BoardProvider {

    private final AdvancedUHC advancedUHC;

    public ScoreboardProviderImplementation(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }

    @Override
    public String getTitle(Player player) {
        return ChatColor.GOLD + ChatColor.BOLD.toString() + "   Advanced UHC   ";
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> strings = new ArrayList<>();
        String host = ChatColor.GOLD + "Host: " + (this.advancedUHC.getGame().getHost() == null ? ChatColor.WHITE + "Not set" : ChatColor.WHITE + Bukkit.getOfflinePlayer(this.advancedUHC.getGame().getHost()).getName());
        strings.add(host);
        return strings;
    }

    private String formatTime(long secs) {
        return String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, secs % 60);
    }
}
