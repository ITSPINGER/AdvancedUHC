package net.pinger.uhc.provider;

import me.missionary.board.provider.BoardProvider;
import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.game.state.GameStates;
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
        return this.advancedUHC.getScoreboardManager().changeScoreboard(player, GameStates.FINISHED);
    }

    private String formatTime(long secs) {
        return String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, secs % 60);
    }
}
