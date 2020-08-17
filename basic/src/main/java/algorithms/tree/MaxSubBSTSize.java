package algorithms.tree;

import java.util.ArrayList;

//最大二叉搜索树
public class MaxSubBSTSize {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        midOrder(head, arr);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void midOrder(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        midOrder(head.left, arr);
        arr.add(head);
        midOrder(head.right, arr);
    }

    public static int maxSubBSTSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
    }

    //获取最大搜索子树大小
    public static int maxSubBSTSize2(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxSubBSTSize;
    }

    // 任何子树
    public static class Info {
        public boolean isAllBST;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(boolean is, int size, int mi, int ma) {
            isAllBST = is;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }

    public static Info process(Node X) {
        if (X == null) {
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int min = X.value;
        int max = X.value;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        boolean isAllBST = false;

        if (
            // 左树整体需要是搜索二叉树
                (leftInfo == null ? true : leftInfo.isAllBST)
                        &&
                        (rightInfo == null ? true : rightInfo.isAllBST)
                        &&
                        // 左树最大值<x
                        (leftInfo == null ? true : leftInfo.max < X.value)
                        &&
                        (rightInfo == null ? true : rightInfo.min > X.value)
        ) {
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    +
                    (rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
                    + 1;
            isAllBST = true;
        }
        return new Info(isAllBST, maxSubBSTSize, min, max);
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }


    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTSize1(head) != maxSubBSTSize2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
