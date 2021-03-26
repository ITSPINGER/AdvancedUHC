package net.pinger.uhc.provider;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.pinger.uhc.AdvancedUHC;
import org.bukkit.entity.Player;

public class PlaceholderProvider extends PlaceholderExpansion {

    /**
     *
     */

    private final AdvancedUHC advancedUHC;

    public PlaceholderProvider(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }

    @Override
    public String getIdentifier() {
        return "uhc";
    }

    @Override
    public String getAuthor() {
        return "ITSPINGER";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        return super.onPlaceholderRequest(p, params);
    }
}
