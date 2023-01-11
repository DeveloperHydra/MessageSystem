package wiki.hydra.messagesystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wiki.hydra.messagesystem.MessageSystem;
import wiki.hydra.messagesystem.utils.Color;

/*
Message System
 | CREATED: Hydra
 | DATE: 2023-01-11 ~ 12:57 AM (EST)
 */

public class MessageCommand implements CommandExecutor {
    private MessageSystem main;

    public MessageCommand(MessageSystem main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        Player player = (Player)sender;
        if (args.length >= 2) {
            if (Bukkit.getPlayerExact(args[0]) != null) {
                Player target = Bukkit.getPlayerExact(args[0]);
                StringBuilder message = new StringBuilder();
                for (int i = 1; i < args.length; i++)
                    message.append(args[i]).append(" ");
                if (target.getName() == player.getName()) {
                    player.sendMessage(Color.translate("&cYou may not message yourself."));
                    return false;
                }
                player.sendMessage(Color.translate("&7(To &a%target%&7) %message%"));
                target.sendMessage(Color.translate("&7(From &a%player%&7) %message%"));
                (this.main.getMessageManager()).recentlyMessaged.put(player, target);
                byte b;
                int j;
                Player[] arrayOfPlayer;
                for (j = (arrayOfPlayer = Bukkit.getOnlinePlayers().toArray(new Player[0])).length, b = 0; b < j; ) {
                    Player all = arrayOfPlayer[b];
                    if (SpyCommand.socialspy.contains(all))
                        all.sendMessage(Color.translate("&dSPY &8» (&a%player% &c-> &a%target%&c) %message%"));
                    b++;
                }
            } else {
                player.sendMessage(Color.translate("&cPlayer not Found"));
            }
        } else {
            player.sendMessage(Color.translate("&cUsage: /message <player> <message>"));
        }
        return false;
    }
}
