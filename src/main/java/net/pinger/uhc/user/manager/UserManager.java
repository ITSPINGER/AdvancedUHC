package net.pinger.uhc.user.manager;

import com.google.common.collect.Maps;
import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.user.AdvancedUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class UserManager {

    /**
     * Map which stores all players which are joining this server in this current session
     */

    private final Map<UUID, AdvancedUser> uuidUserMap = Maps.newHashMap();

    /**
     * The instance of the java plugin
     */

    private final AdvancedUHC advancedUHC;

    public UserManager(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }

    /**
     * Stores the uuid of the player in the map
     * @param player the player which is being stored
     */

    public void createPlayer(Player player) {
        this.createPlayer(player.getUniqueId());
    }

    /**
     * Stores the uuid in the map and creates {@link AdvancedUser} object with uuid
     * @param id the uuid which is being stored
     */

    public void createPlayer(UUID id) {
        if (this.uuidUserMap.containsKey(id))
            return;

        AdvancedUser advancedUser = new AdvancedUser(this.advancedUHC, id);
        this.uuidUserMap.put(id, advancedUser);
    }

    /**
     * This method returns all {@link AdvancedUser} that are currently on the server
     * If there are any users that aren't stored in the map (which shouldn't happen) this will run {@link UserManager#createPlayer(UUID)}
     * @return the collection of online users
     */

    public Collection<? extends AdvancedUser> getOnlinePlayers() {
        Collection<AdvancedUser> users = Collections.emptyList();
        for (Player p : Bukkit.getOnlinePlayers()) {
            this.createPlayer(p);
            users.add(this.uuidUserMap.get(p.getUniqueId()));
        }

        return users;
    }
}
