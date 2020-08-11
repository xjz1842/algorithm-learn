package algorithms.leetcode;


import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0) return null;

        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 1->2-> 3
        // 3- 2 - 1
        int index = list.size() - n;

        if (index == 0) {
            ListNode newHead = list.get(0).next;
            return newHead;
        }
        //prepare to remove
        ListNode node = list.get(index);
        ListNode pre = list.get(index - 1);

        //头节点
        if (node.next == null) {
            pre.next = null;
        } else {
            pre.next = node.next;
        }
        return list.get(0);
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        head = removeNthFromEnd(head, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
