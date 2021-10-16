package com.algorithms.leetcode.fourhundred;

import java.util.Stack;

public class leetcode_388_LengthLongestPath {

    /**
     * 栈模拟
     * 从左到右逐个进行解析:
     * 遇到\n，新起一行
     * 遇到\t，计数有几个\t，保存到变量tcount中，如果tcount<len(stack)，需要将stack中的元素出栈，
     * 直至len(stack) == tcount，然后将当前行加入栈中。
     * 如果最后的名字中含有'.'，说明是文件，需要保存当前最大的路径长度
     * 重复上述过程，直至所有字符都被变量完
     */
    public static int lengthLongestPat(String input) {
        int maxLen = 0;
        //栈模拟
        Stack<String> stack = new Stack<>();
        //记录文件路径长度
        int fileLen = 0;
        //当前第几层
        int level = 0;
        for (int i = 0; i < input.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            while (i < input.length() && input.charAt(i) != '\n') {
                stringBuilder.append(input.charAt(i));
                i++;
            }
            //然后接卸\t个数
            int nextLevel = 0;
            while (i < input.length()-1 && input.charAt(i+1) == '\t'){
                nextLevel++;
                i++;
            }
            //出栈 直到level == stack.size
            while (level < stack.size()){
                String dir = stack.pop();
                fileLen -= dir.length()+1;
            }
            level = nextLevel;
            // 判断是否是文件
            if (stringBuilder.toString().indexOf(".") > 0) {
                maxLen = Math.max(maxLen,fileLen + stringBuilder.toString().length());
            } else {
                //非文件
                stack.push(stringBuilder.toString());
                fileLen += stringBuilder.toString().length()+1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPat(input));
    }
}
