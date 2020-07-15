package comalgorithms.LinkList;


public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode[] list = new ListNode[k];

        int[] values = new int[k];

        list[0] = head;
        values[0] = head.val;
        ListNode cur = head;
        for (int i = 1; i < k; i++) {
            ListNode next = cur.next;
            if (next == null) return null;
            list[i] = next;
            values[i] = next.val;
            cur = cur.next;
        }

        while (list != null) {
            for (int i = 0, j = k - 1; i < k && j >= 0; i++, j--) {
                list[i].val = values[j];
            }

            boolean flag = false;

            ListNode next = list[k - 1].next;
            for (int i = 0; i < k; i++) {
                if (next == null) {
                    flag = true;
                    break;
                }
                list[i] = next;
                values[i] = next.val;
                next = next.next;
            }

            if (flag) break;
        }
        return head;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next = new ListNode(6);


        ListNode head = reverseKGroup(listNode, 4);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
