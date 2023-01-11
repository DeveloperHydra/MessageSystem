package wiki.hydra.messagesystem.utils;

import java.util.HashMap;
import org.bukkit.entity.Player;
import wiki.hydra.messagesystem.MessageSystem;

/*
Message System
 | CREATED: Hydra
 | DATE: 2023-01-11 ~ 12:57 AM (EST)
 */

public class MessageManager {
    private MessageSystem messageSystem;

    public HashMap<Player, Player> recentlyMessaged;

    public MessageManager(MessageSystem messageSystem) {
        this.recentlyMessaged = new HashMap<>();
        this.messageSystem = messageSystem;
    }
}
