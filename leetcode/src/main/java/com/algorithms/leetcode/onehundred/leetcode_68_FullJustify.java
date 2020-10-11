package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_68_FullJustify {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }

    private static String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) {
            return padResult(words[left], maxWidth);
        }
        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++) {
            result.append(words[i]);
            result.append(space);
            //左边多于右边
            result.append(remainder-- > 0 ? " " : "");
        }
        return padResult(result.toString().trim(), maxWidth);
    }

    //当前单词的长度
    private static int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }

    private static String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private static String blank(int length) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < length; i++) {
            space.append(" ");
        }
        return space.toString();
    }

    //找到当前行最右边的单词下标
    private static int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right++].length();
        }
        return right - 1;
    }

    public static void main(String[] args) {
        String s = "What,must,be,acknowledgment,shall,be";
        String[] words = s.split(",");
        List<String> list = fullJustify(words, 16);

        for (String str : list) {
            System.out.println(str);
        }
    }
}
