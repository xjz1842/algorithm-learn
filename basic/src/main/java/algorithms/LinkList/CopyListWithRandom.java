package algorithms.LinkList;


import java.util.HashMap;

public class CopyListWithRandom {

    public static ListNode copyListWithRand1(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;

        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;

        while (cur != null) {
            // cur 老
            // map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void printRandLinkedList(ListNode head) {
        ListNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode copyListWithRand2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = null;
        // copy node and link to every node
        // 1 -> 2
        // 1 -> 1' -> 2
        while (cur != null) {
            // cur 老   next 老的下一个
            next = cur.next;
            cur.next = new ListNode(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        ListNode curCopy = null;
        // set copy node rand
        // 1 -> 1' -> 2 -> 2'
        while (cur != null) {
            // cur 老
            // cur.next  新 copy
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        // head  head.next
        ListNode res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode head = null;
        ListNode res1 = null;
        ListNode res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
    }

}
