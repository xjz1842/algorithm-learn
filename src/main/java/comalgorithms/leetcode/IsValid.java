package comalgorithms.leetcode;

import java.util.Stack;

public class IsValid {

    public static boolean isValid(String s) {

        if (s == null) return false;

        if (s.length() == 0) return true;

        if (s.length() < 2) return false;

        char[] ss = s.toCharArray();

        Stack stack = new Stack();
        for (char c : ss) {
            if (c == ')') {
                if (stack.empty()) return false;
                char ch = (char) stack.pop();
                if (ch != '(') {
                    return false;
                } else {
                    continue;
                }
            } else if (c == ']') {
                if (stack.empty()) return false;
                char ch = (char) stack.pop();
                if (ch != '[') {
                    return false;
                } else {
                    continue;
                }
            } else if (c == '}') {
                if (stack.empty()) return false;
                char ch = (char) stack.pop();
                if (ch != '{') {
                    return false;
                } else {
                    continue;
                }
            }
            {
                stack.push(c);
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        String s = "((";
        System.out.println(isValid(s));
    }

}
