package com.algorithms.leetcode.fourhundred;

public class leetcode_345_ReverseVowels {

    public static String reverseVowels(String s) {
        if(s == null || s.length() == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l < r){
            //找到左边的元音字符
            while (l < r && !validChar(chars[l])){
                l++;
            }
            //找到右边的元音字符
            while (l < r && !validChar(chars[r])){
                r--;
            }
            if(validChar(chars[l]) && validChar(chars[r])){
                //交换
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    public static  boolean validChar(char c ){
          return (c == 'a'|| c == 'e'|| c == 'i'|| c =='o'|| c == 'u'
          || c == 'A'|| c == 'E'|| c == 'I'|| c =='O'|| c == 'U');
    }

    public static void main(String[] args) {
        String s = "aA";
        System.out.println(reverseVowels(s));
    }
}
