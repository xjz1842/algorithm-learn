package com.algorithms.sword.to.offer;


import java.util.HashMap;
import java.util.Map;

public class Offer_07_BuildTree {

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static  TreeNode buildTree(int[] preorder, int[] inorder) {
        int preL = 0;
        int preR = preorder.length;
        int inL = 0;
        int inR = inorder.length;
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            indexMap.put(inorder[i],i);
        }
        return buildTree(preorder, preL, preR - 1, inorder, inL, inR - 1,indexMap);
    }

    public static TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR,Map<Integer,Integer> indexMap) {
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);

        //find inorder index
        int inOrderIndex = indexMap.get(preorder[preL]);

        //左子树长度
        int leftSize = inOrderIndex - inL;

        root.left = buildTree(preorder, preL + 1, preL + leftSize, inorder, inL, inOrderIndex-1,indexMap);
        root.right = buildTree(preorder, preL+leftSize+1, preR, inorder, inOrderIndex + 1, inR,indexMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder));
    }
}
