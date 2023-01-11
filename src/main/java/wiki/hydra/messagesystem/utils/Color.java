package wiki.hydra.messagesystem.utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;

/*
Message System
 | CREATED: Hydra
 | DATE: 2023-01-11 ~ 12:57 AM (EST)
 */

public class Color {

    public static String translate(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static List<String> colorList(List<String> list) {
        List<String> newlist = new ArrayList<>();

        for (String s : list) {
            newlist.add(translate(s));
        }

        return newlist;
    }
}
