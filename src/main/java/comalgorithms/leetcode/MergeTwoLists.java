package comalgorithms.leetcode;

public class MergeTwoLists {

    public static RemoveNthFromEnd.ListNode mergeTwoLists(RemoveNthFromEnd.ListNode l1, RemoveNthFromEnd.ListNode l2) {

        RemoveNthFromEnd.ListNode newNode = null;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newNode = new RemoveNthFromEnd.ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode = new RemoveNthFromEnd.ListNode(l1.val);
                l1 = l1.next;
            }
        }
        RemoveNthFromEnd.ListNode head = newNode;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newNode.next = new RemoveNthFromEnd.ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode.next = new RemoveNthFromEnd.ListNode(l1.val);
                l1 = l1.next;
            }
            newNode = newNode.next;
        }

        while (l1 != null) {
            newNode.next = new RemoveNthFromEnd.ListNode(l1.val);
            newNode = newNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            newNode.next = new RemoveNthFromEnd.ListNode(l2.val);
            newNode = newNode.next;
            l2 = l2.next;
        }

        return head;
    }

    public static void main(String[] args) {

        RemoveNthFromEnd.ListNode head = new RemoveNthFromEnd.ListNode(1);
        head.next = new RemoveNthFromEnd.ListNode(2);
        head.next.next = new RemoveNthFromEnd.ListNode(4);

        RemoveNthFromEnd.ListNode head1 = new RemoveNthFromEnd.ListNode(1);
        head1.next = new RemoveNthFromEnd.ListNode(3);
        head1.next.next = new RemoveNthFromEnd.ListNode(4);

        RemoveNthFromEnd.ListNode resHead = mergeTwoLists(head, head1);

        while (resHead != null) {

            System.out.println(resHead.val);
            resHead = resHead.next;
        }
    }

}
