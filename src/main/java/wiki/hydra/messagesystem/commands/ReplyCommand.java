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

public class ReplyCommand implements CommandExecutor {
    private MessageSystem main;

    public ReplyCommand(MessageSystem main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        Player player = (Player)sender;
        Player target = (Player)(this.main.getMessageManager()).recentlyMessaged.get(player);
        if (args.length > 0) {
            if ((this.main.getMessageManager()).recentlyMessaged.containsKey(player)) {
                if ((this.main.getMessageManager()).recentlyMessaged.get(player) != null) {
                    StringBuilder message = new StringBuilder();
                    for (int i = 0; i < args.length; i++)
                        message.append(args[i]).append(" ");
                    player.sendMessage(Color.translate("&7(To &a%target%&7) %message%"));
                    target.sendMessage(Color.translate("&7(From &a%player%&7) %message%"));
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
                    player.sendMessage(Color.translate("&cPlayer has logged out."));
                }
            } else {
                player.sendMessage(Color.translate("&cYou have not messaged any players recently"));
            }
        } else {
            player.sendMessage(Color.translate("&cUsage: /reply <message>"));
        }
        return false;
    }
}