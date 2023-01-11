package wiki.hydra.messagesystem;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import wiki.hydra.messagesystem.commands.MessageCommand;
import wiki.hydra.messagesystem.commands.ReplyCommand;
import wiki.hydra.messagesystem.commands.SpyCommand;
import wiki.hydra.messagesystem.utils.MessageManager;

/*
Message System
 | CREATED: Hydra
 | DATE: 2023-01-11 ~ 12:57 AM (EST)
 */

public class MessageSystem extends JavaPlugin {
    private MessageManager messageManager;
    public static MessageSystem instance;

    public void onEnable() {
        instance = this;
        getCommand("message").setExecutor((CommandExecutor)new MessageCommand(this));
        getCommand("reply").setExecutor((CommandExecutor)new ReplyCommand(this));
        getCommand("spy").setExecutor((CommandExecutor)new SpyCommand());
        this.messageManager = new MessageManager(this);
    }

    public MessageManager getMessageManager() {
        return this.messageManager;
    }

    public static JavaPlugin getInstance() {
        return null;
    }
}
