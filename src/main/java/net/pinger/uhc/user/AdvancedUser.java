package net.pinger.uhc.user;

import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.user.state.UserStates;

import java.util.UUID;

public class AdvancedUser {

    /**
     * Represents the uuid of the player
     */

    private final UUID uniqueId;

    /**
     * The current user state of the player
     */

    private UserStates userStates;

    /**
     * The default instance of the plugin
     */

    private final AdvancedUHC advancedUHC;


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
