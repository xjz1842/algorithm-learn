package com.algorithms.leetcode.fourhundred;


public class leetcode_306_IsAdditiveNumber {

    public static boolean isAdditiveNumber(String num) {
     //检查
     if (num == null) {
         return false;
     }

     char[] chars = num.toCharArray();
     //回溯
     return dfs(0,num,chars,0,0,0);
    }

    /**
     * i 索引
     * num 数组
     * chars 数组
     * preValue 
     * @param args
     */
    private static boolean dfs(int i,String num, char[] chars,int prepreValue, int preValue, int count) {
       if(i == chars.length && count >= 3){
            return true;
        }
        int cur = 0;
        for(int j = i; j < chars.length; j++){ 

             if(j > i && chars[i] == '0'){
                break;
             }
            cur = 10 * cur + (chars[j] - '0');
            if(count < 2){
                if(dfs(j+1, num,chars,preValue, cur, count+1)){
                    return true;
                }
            }
            if(cur == (prepreValue + preValue)){
              if(dfs(j+1,num,chars,preValue,cur, count+1)){
                  return true;
              }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String num = "112358";
        System.out.println(isAdditiveNumber(num));
    }
}
