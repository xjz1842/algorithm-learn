package com.algorithms.leetcode.fourhundred;

public class leetcode_395_LongestSubstring {

    public static int longestSubstring(String s, int k) {
        final int size = 26;
        int len = s.length();
        char[] chars  = s.toCharArray();
        //收集答案
        int result = 0;
        //枚举集合 1 - 26个字符种类
        for(int i = 0; i < size;i++){
            //左右边界
            int l = 0;
            int r = 0;
            //字符种类没有到达k个种类
            int less = 0;
            //总的字符种类
            int total = 0;
            //统计字符个数
            int[] count = new int[26];
            while (r < len){
                count[chars[r]-'a']++;
                if(count[chars[r]-'a'] == 1){
                    less++;
                    total++;
                }
                if(count[chars[r]-'a'] == k){
                    less--;
                }
                //大于 i ，说明要左移，让total减少
                while (total > i){
                    count[chars[l]-'a']--;
                    if(count[chars[l]-'a'] == k-1){
                        less++;
                    }
                    if(count[chars[l]-'a'] == 0){
                        total--;
                        less--;
                    }
                    l++;
               }
               if (less == 0){
                   result = Math.max(result,r-l+1);
               }
               r++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(longestSubstring(s,k));
    }

}
