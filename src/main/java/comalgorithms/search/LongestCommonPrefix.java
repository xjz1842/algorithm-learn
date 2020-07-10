package comalgorithms.search;


public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0 || strs.length == 1) {
            return "";
        }

        int len = strs.length;
        StringBuilder prefixBuilder = new StringBuilder();
        String prefix = "";
        char[] chars = strs[0].toCharArray();

        for (int i = 0; i < chars.length; i++) {
            prefix = prefixBuilder.append(chars[i]).toString();
            for (int j = 1; j < len; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(str));
    }
}
