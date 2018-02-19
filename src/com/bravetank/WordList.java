package com.bravetank;

public class WordList {

    private String word;

    public static String getWord() {
        String[] names =
                {"explain", "truck", "unite", "branch", "decisive", "notice"};
        String word = names[(int) (Math.random() * names.length)];
        return word;

    }
}