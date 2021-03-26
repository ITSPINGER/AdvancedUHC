package net.pinger.uhc;

import me.missionary.board.BoardManager;
import me.missionary.board.settings.BoardSettings;
import me.missionary.board.settings.ScoreDirection;
import net.pinger.uhc.provider.ScoreboardProviderImplementation;
import org.bukkit.plugin.java.JavaPlugin;
import net.pinger.uhc.provider.manager.ScoreboardManager;

public class AdvancedUHC extends JavaPlugin {

    private BoardManager boardManager;
    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {
        this.boardManager = new BoardManager(this, BoardSettings.builder().boardProvider(new ScoreboardProviderImplementation(this)).scoreDirection(ScoreDirection.UP).build());
        this.scoreboardManager = new ScoreboardManager(this);
    }

    @Override
    public void onDisable() {
        this.boardManager.onDisable();
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}
