package com.algorithms.leetcode.threehundred;

import java.util.HashMap;
import java.util.Map;

public class leetcode_299_GetHint {

    public static String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0) {
            return "";
        }
        if (secret.length() != guess.length()) {
            return "";
        }
        Map<Character, Integer> cache = new HashMap<>();

        for (Character ch : secret.toCharArray()) {
            Integer count = cache.get(ch);
            if (count != null) {
                cache.put(ch, count + 1);
            } else {
                cache.put(ch, 1);
            }
        }
        //digit and location is correct
        int digitAndLocationCorrect = 0;
        // digit correct
        int digitCorrect = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                digitAndLocationCorrect++;
            }
            Integer count = cache.get(guess.charAt(i));
            if (count != null && count > 0) {
                cache.put(guess.charAt(i), count - 1);
                digitCorrect++;
            }
        }
        int digitCorrectAndLocationError = digitCorrect - digitAndLocationCorrect;
        return digitAndLocationCorrect + "A" + digitCorrectAndLocationError + "B";
    }

    public static void main(String[] args) {
        String secret = "1122";
        String guess = "1222";
        System.out.println(getHint(secret, guess));
    }
}
