package algorithms.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findSubstring {


    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordNum = words.length;

        if (wordNum == 0) return result;

        int wLen = words[0].length();

        int wTotalLen = wLen * words.length;

        int count = words.length;

        String[] wordCopy = new String[words.length];

        System.arraycopy(words, 0, wordCopy, 0, words.length);

        for (int i = 0; i <= s.length() - wTotalLen; i++) {

            for (int j = 0; j < words.length && (j + 1) * wLen <= s.length(); j++) {

                String substr = s.substring(i + j * wLen, i + (j + 1) * wLen);

                boolean isExist = false;

                for (int k = 0; k < words.length; k++) {
                    if (substr.equals(words[k])) {
                        words[k] = null;
                        isExist = true;
                        count--;
                        break;
                    }
                }
                if (!isExist) {
                    break;
                }
            }

            if (count == 0) {
                result.add(i);
            }
            count = words.length;
            //恢复
            System.arraycopy(wordCopy, 0, words, 0, wordCopy.length);

        }
        return result;
    }


    public static void main(String[] args) {

        String s = "a";
        String[] words = {"a"};

        List<Integer> list = findSubstring(s, words);

        System.out.println(list);
    }
}
