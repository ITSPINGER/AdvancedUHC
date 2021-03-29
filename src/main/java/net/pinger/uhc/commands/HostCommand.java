package net.pinger.uhc.commands;

import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.game.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HostCommand implements CommandExecutor {

    private final AdvancedUHC advancedUHC;

    public HostCommand(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Consoles may not use this command.");
            return true;
        }

        Player player = (Player) commandSender;
        if (!player.hasPermission("uhc.host")) {
            player.sendMessage(ChatColor.RED + "You may not use this command.");
            return true;
        }

        Game game = this.advancedUHC.getGame();
        if (game.getHost() == null) {
            game.setHost(player.getUniqueId());
            player.sendMessage(ChatColor.GREEN + "You have been set as the host.");
            return true;
        }

        if (game.getHost().equals(player.getUniqueId())) {
            game.setHost(null);
            player.sendMessage(ChatColor.GREEN + "You are no longer hosting this game.");
            return true;
        }

        game.setModerator(player.getUniqueId());
        player.sendMessage(ChatColor.GREEN + "You have been set as the moderator.");
        return true;
    }
}
