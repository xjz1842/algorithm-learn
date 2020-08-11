package algorithms.LinkList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {

        if (head == null) return null;

        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null && next != null) {
            swap(cur, next);
            cur = next.next;
            if (cur == null) break;
            next = next.next.next;
            if (next == null) break;
        }
        return head;
    }

    public static void swap(ListNode n1, ListNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(5);

        ListNode head = swapPairs(listNode);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}



