package net.pinger.uhc.user;

import com.google.common.collect.Maps;
import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.user.state.UserStates;
import org.bukkit.block.Block;

import java.util.Map;
import java.util.UUID;

public class AdvancedUser {

    /**
     * The uuid of theAdvancedUser
     */

    private final UUID uniqueId;

    /**
     * The current {@link UserStates} of the player
     */

    private UserStates userStates = UserStates.PLAYING;

    /**
     * The default instance of the plugin
     */

    private final AdvancedUHC advancedUHC;

    /**
     * This is used for registering specific blocks mined by a player
     * It's used to help prevent player using X-Ray from mining a lot of ores fast by notifying the moderators
     */

    private final Map<Block, Integer> blocksMined = Maps.newHashMap();

    public AdvancedUser(AdvancedUHC uhc, UUID uuid) {
        this.advancedUHC = uhc;
        this.uniqueId = uuid;
    }

    public void setUserStates(UserStates userStates) {
        this.userStates = userStates;
    }

    public UserStates getUserStates() {
        return userStates;
    }

    public AdvancedUHC getAdvancedUHC() {
        return advancedUHC;
    }
}
