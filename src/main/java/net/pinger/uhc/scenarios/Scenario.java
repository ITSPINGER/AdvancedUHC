package net.pinger.uhc.scenarios;

import net.pinger.uhc.AdvancedUHC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.List;

public abstract class Scenario implements Comparable<Scenario>, Listener {

    /* The default instance of the plugin */
    private final AdvancedUHC advancedUHC;


    /* Returns whether this current scenario is enabled*/
    private boolean enabled = false;


    public Scenario(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }

    /**
     * Returns the name of this scenario
     * @return the name
     */

    public abstract String getName();

    /**
     * Returns the material of this scenario used for displaying purposes
     * @return the material
     */

    public abstract Material getMaterial();

    /**
     * Returns the explanation of the scenario
     * @return the explanation
     */

    public abstract List<String> getExplanation();

    /**
     * Returns the current scenario state in a beautiful format
     * @return the state
     */

    public String getState() {
        return this.enabled ? "§aEnabled" : "§cDisabled";
    }

    /**
     * Changes the state of the scenario to enabled / disable
     * If the game hasn't started, we won't update the listeners because it might cause bugs
     * @param enabled change the bool
     */

    public void setEnabled(boolean enabled) {
        // Check whether the game has started (ADD WHEN DONE)
        boolean started = false; // This is just a check so that we have an idea of how the enabling will work
        this.enabled = enabled;

        // Missing a broadcasting message notifying of the scenario change

        if (!started) {
            return;
        }

        if (enabled) {
            Bukkit.getPluginManager().registerEvents(this, this.advancedUHC);
        } else {
            HandlerList.unregisterAll(this);
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
