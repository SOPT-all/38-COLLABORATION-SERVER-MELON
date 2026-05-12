package org.sopt.collaboration.melon.global.utils;

public class TimeFormatUtils {

    public static String formatSeconds(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format("%d:%02d", minutes, seconds);

    }
}
