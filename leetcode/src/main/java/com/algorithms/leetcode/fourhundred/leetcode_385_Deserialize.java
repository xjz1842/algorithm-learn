package com.algorithms.leetcode.fourhundred;

import java.util.List;
import java.util.Stack;

/**
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 * <p>
 * 列表中的每个元素只可能是整数或整数嵌套列表
 * <p>
 * 提示：你可以假定这些字符串都是格式良好的：
 * <p>
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9、[、-、,、]
 * <p>
 * 示例 1：
 * <p>
 * 给定 s = "324",
 * <p>
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/mini-parser
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_385_Deserialize {
    static class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }
        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }
        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        boolean isInteger() {
            return true;
        }
        /**
         * @return the single integer that this NestedInteger holds, if it holds a single integer
         * Return null if this NestedInteger holds a nested list
         */
        Integer getInteger() {
            return null;
        }
        /**
         * Set this NestedInteger to hold a single integer.
         */
        void setInteger(int value) {
        }
        /**
         * Set this NestedInteger to hold a nested list and adds a nested integer to it.
         */
        void add(NestedInteger ni) {
        }
        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested list
         * Return empty list if this NestedInteger holds a single integer
         */
        List<NestedInteger> getList() {
            return null;
        }
    }

    /**
     *  Stack 模拟
     *
     */
    public static NestedInteger deserialize(String s) {
        //如果是数字开头
        if (s == null || s.length() == 0){
            return new NestedInteger();
        }
        if (s.charAt(0) != '['){
            return new NestedInteger(Integer.parseInt(s));
        }
        NestedInteger ans = new NestedInteger();
        NestedInteger nestedInteger = new NestedInteger();
        //栈
        Stack<NestedInteger> stack = new Stack<>();
        //设置空对象
        stack.push(nestedInteger);
        //索引
        for (int index = 0; index < s.length();index++) {
            if (s.charAt(index) == ',') {
                continue;
            }
            if (s.charAt(index) == '[') {
                NestedInteger nestNode = new NestedInteger();
                stack.peek().add(nestNode);
                stack.push(nestNode);
            } else if (s.charAt(index) == ']') {
                ans = stack.pop();
            } else {
                int start = index;
                while ((index + 1) < s.length() && Character.isDigit(s.charAt(index + 1))) {
                    index++;
                }
                NestedInteger ni = new NestedInteger(Integer.parseInt(s.substring(start, index + 1)));
                stack.peek().add(ni);
            }
        }
        return ans;
    }

}
