package net.pinger.uhc.events;

import net.pinger.uhc.AdvancedUHC;
import org.bukkit.event.Listener;

public class PlayerJoinGameEvent implements Listener {

    private final AdvancedUHC advancedUHC;

    public PlayerJoinGameEvent(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }
}
