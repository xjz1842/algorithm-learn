package com.algorithms.leetcode.onehundred;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leetcode_71_SimplifyPath {

    public static String simplifyPath(String path) {
        if (path == null) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        String[] pathArr = path.split("/");

        for (int i = 0; i < pathArr.length; i++) {
            if (".".equals(pathArr[i]) || "".equals(pathArr[i])) {
                continue;
            }
            if ("..".equals(pathArr[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(pathArr[i]);
            }
        }
        List<String> res = new LinkedList<>();
        while (!stack.empty()) {
            res.add(0, stack.pop());
        }
        if (res.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        for (String s : res) {
            stringBuilder.append(s).append("/");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }

}
