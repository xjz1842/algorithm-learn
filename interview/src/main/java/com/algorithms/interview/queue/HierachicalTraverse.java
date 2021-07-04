package com.algorithms.interview.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
  【题目】 从上到下按层打印二叉树，同一层结点按从左到右的顺序打印，每一层打印到一行。
 */
public class HierachicalTraverse {

    public static List<List<Integer>> levelOrder1(TreeNode root){
       // 生成FIFO队列
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        //如果结点不为空，那么加入FIFO队列
        if(root != null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
           // 取出当前层里面元素的个数
            int curLevelSize = queue.size();
            //当前层的结果存放于curResult链表中
            List<Integer> curResult = new ArrayList<>();

            for(int i = 0; i < curLevelSize; i++){
                TreeNode cur = queue.poll();
                curResult.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ans.add(curResult);
        }
        return ans;
    }

    //每一层分一批遍历
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        //生成FIFO队列
        List<TreeNode> curLevel = new LinkedList<>();
        if (root != null) {
            curLevel.add(root);
        }

        while (!curLevel.isEmpty()) {
          // 准备用来存放下一层的结点
            List<TreeNode> nextLevel = new ArrayList<>();
        // 用来存放当前层的结果
            List<Integer> curResult = new ArrayList<>();

            for (TreeNode node : curLevel) {
                curResult.add(node.val);
                // 生成下一层
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            //注意这里的更迭!滚动前进
            curLevel = nextLevel;
            //获取当前行结果
            ans.add(curResult);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(2,null,null);
        root.right = new TreeNode(3,null,null);

        for (List<Integer> i : levelOrder1(root)) {
            for(Integer j : i){
                System.out.print(j +" ");
            }
            System.out.println();
        }

        for (List<Integer> i : levelOrder2(root)) {
            for(Integer j : i){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
}
