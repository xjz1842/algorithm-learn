package algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SnakeTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void snakeTraversal(Node head) {
        if (head == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        int level = 1;
        Stack<Node> stack = new Stack<>();
        while (!queue.isEmpty() || !stack.isEmpty()) {
            if ((level & 1) == 1) {
                while (!queue.isEmpty()) {
                    Node next = queue.poll();
                    System.out.println(next.value);
                    if (next.left != null) {
                        //奇数
                        stack.push(next.left);
                    }
                    if (next.right != null) {
                        stack.push(next.right);
                    }
                }
                level++;
            } else {
                //偶数
                Stack<Node> stack1 = new Stack<>();

                while (!stack.isEmpty()) {
                    Node next = stack.pop();
                    System.out.println(next.value);
                    if (next.right != null) {
                        stack1.push(next.right);
                    }
                    if (next.left != null) {
                        stack1.push(next.left);
                    }
                }
                while (!stack1.isEmpty()) {
                    queue.offer(stack1.pop());
                }
                level++;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        snakeTraversal(head);
        System.out.println("========");

    }
}
