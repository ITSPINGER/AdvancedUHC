package net.pinger.uhc;

import me.missionary.board.BoardManager;
import me.missionary.board.settings.BoardSettings;
import me.missionary.board.settings.ScoreDirection;
import net.pinger.uhc.commands.HostCommand;
import net.pinger.uhc.events.PlayerPreJoinEvent;
import net.pinger.uhc.game.Game;
import net.pinger.uhc.provider.ScoreboardProviderImplementation;
import net.pinger.uhc.provider.manager.ScoreboardManager;
import net.pinger.uhc.user.manager.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancedUHC extends JavaPlugin {

    private BoardManager boardManager;
    private ScoreboardManager scoreboardManager;
    private UserManager userManager;
    private Game game;

    @Override
    public void onEnable() {
        this.boardManager = new BoardManager(this, BoardSettings.builder().boardProvider(new ScoreboardProviderImplementation(this)).scoreDirection(ScoreDirection.UP).build());
        this.scoreboardManager = new ScoreboardManager(this);
        this.userManager = new UserManager(this);
        this.game = new Game();

        Bukkit.getPluginManager().registerEvents(new PlayerPreJoinEvent(this), this);
        getCommand("host").setExecutor(new HostCommand(this));

        for (Player p : Bukkit.getOnlinePlayers()) {
            this.userManager.createPlayer(p);
        }
    }

    @Override
    public void onDisable() {
        this.boardManager.onDisable();
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Game getGame() {
        return game;
    }
}
