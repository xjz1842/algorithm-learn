package com.algorithms.interview.backtrace;

import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class LetterCombinations {

    static final String[] map = new String[]{ //
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    public static void backtrace(String digits, int i, StringBuffer box, List<String> ans) {
        final int N = digits == null ? 0 : digits.length();

        // 如果我们发现状态满足要求
        if (box.length() == N) {
            ans.add(box.toString());
        }
        // 如果发现越界, 第N个人开始就没有宝石选项了
        if (i >= N) {
            return;
        }
        // 遍历第i个人可以选择的宝石
        final int stoneIndex = (int) (digits.charAt(i) - '0');

        for (int idx = 0; idx < map[stoneIndex].length(); idx++) {
            // 拿到宝石
            Character stone = map[stoneIndex].charAt(idx);
            // 放到箱子中
            box.append(stone);
            // 开始处理第i + 1个人
            backtrace(digits, i + 1, box, ans);
            // 把自己的宝石拿出来，然后保持箱子原
            box.deleteCharAt(box.length() - 1);
        }
    }

    public static  List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        StringBuffer box = new StringBuffer();
        List<String> ans = new ArrayList<>();
        /* 从第0个人开始 */
        backtrace(digits, 0, box, ans);
        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
