package net.pinger.uhc.provider.manager;

import com.google.common.collect.Lists;
import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.game.state.GameStates;
import org.bukkit.entity.Player;

import java.util.List;

public class ScoreboardManager {

    /**
     * The default instance of the plugin
     */

    private final AdvancedUHC advancedUHC;

    public ScoreboardManager(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }

    public List<String> changeScoreboard(Player player, GameStates gameStates) {
        return Lists.newArrayList();
    }
}
