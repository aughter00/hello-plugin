package hello.helloPlugin;

import net.md_5.bungee.api.ChatColor;
import java.awt.Color;

public final class MessageBeautify {
    public static final Color[] COLOR_GRADATION = new Color[]{
            new Color(0xe60000),
            new Color(0xe67300),
            new Color(0xe6e600),
            new Color(0x73e600),
            new Color(0x00e600),
            new Color(0x00e673),
            new Color(0x00e6e6),
    };

    public static String makeMessageGradation(String str, Integer colorNum) {
        String newString = "";
        int n = str.length();
        final int _colorNum = colorNum;
        for(int i=0; i<n; i++) {
            newString += ChatColor.of(COLOR_GRADATION[i % _colorNum]);
            newString += str.charAt(i);
        }
        return newString;
    }

    public static String makeMessageGradation(String str) {
        return makeMessageGradation(str, COLOR_GRADATION.length);
    }

    public static String makeMessageGradationBySwitch(String str) {
        String newString = "";
        int n = str.length();
        final int colorNum = 7;
        for(int i=0; i<n; i++) {
            switch(i % colorNum) {
                case 0:
                    newString += ChatColor.of("#e60000");
                    break;

                case 1:
                    newString += ChatColor.of("#e67300");
                    break;

                case 2:
                    newString += ChatColor.of("#e6e600");
                    break;

                case 3:
                    newString += ChatColor.of("#73e600");
                    break;

                case 4:
                    newString += ChatColor.of("#00e600");
                    break;

                case 5:
                    newString += ChatColor.of("#00e673");
                    break;

                case 6:
                    newString += ChatColor.of("#00e6e6");
                    break;
            }
            newString += str.charAt(i);
        }
        return newString;
    }
}
