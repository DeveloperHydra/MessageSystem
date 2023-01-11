package wiki.hydra.messagesystem.commands;

import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wiki.hydra.messagesystem.utils.Color;

/*
Message System
 | CREATED: Hydra
 | DATE: 2023-01-11 ~ 12:57 AM (EST)
 */

public class SpyCommand implements CommandExecutor {
    static ArrayList<Player> socialspy = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("spy.use")) {
            player.sendMessage(Color.translate("&cYou do not have permission to execute this command."));
            return true;
        }
        if (socialspy.contains(player)) {
            player.sendMessage(Color.translate("&dSPY &8» &7You have &cdisabled &7social spy."));
            socialspy.remove(player);
            return true;
        }
        player.sendMessage(Color.translate("&dSPY &8» &7You have &aenabled &7social spy."));
        socialspy.add(player);
        return true;
    }
}
