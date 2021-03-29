package net.pinger.uhc.game;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.pinger.uhc.game.state.GameStates;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Game {

    /**
     * The uuid of the player that is hosting the game
     */

    private UUID host;

    /**
     * UUID's of the players that are moderators of the game
     */

    private final Set<UUID> moderators = Sets.newHashSet();

    /**
     * The current {@link GameStates} of the game
     */

    private GameStates gameState = GameStates.LOBBY;


    public GameStates getGameState() {
        return gameState;
    }

    public UUID getHost() {
        return host;
    }

    public void setHost(UUID host) {
        this.host = host;
    }

    public boolean setModerator(UUID moderator) {
        return this.moderators.add(moderator);
    }

    public boolean revokeModerator(UUID moderator) {
        return this.moderators.remove(moderator);
    }
}
