package net.pinger.uhc.game.config;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public enum GameConfig {

    STEAK(20, Material.COOKED_BEEF, "Steak Given"),
    NETHER(false, Material.NETHER_STAR, "Nether");




    private final Object val;
    private final Material material;
    private String name;

    GameConfig(Object value, Material material, String name) {
        this.val = value;
        this.material = material;
        this.name = name;
    }

    public Object getVal() {
        return val;
    }


}
