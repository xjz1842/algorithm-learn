package algorithms.LinkList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0){
            return null;
        }

        if (lists.length == 1 && lists[0] == null) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        ListNode head = new ListNode(0);
        ListNode node = head;

        while (!priorityQueue.isEmpty()) {
            ListNode pop = priorityQueue.poll();
            ListNode next = new ListNode(pop.val);

            if (pop.next != null) {
                priorityQueue.offer(pop.next);
            }
            node.next = next;
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {


        ListNode[] listNodes = new ListNode[3];
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        listNodes[0] = listNode;

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        listNodes[1] = listNode1;

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(6);
        listNodes[2] = listNode2;

        ListNode listNode3 = mergeKLists(listNodes);

        while (listNode3 != null) {
            System.out.println(listNode3.val);
            listNode3 = listNode3.next;
        }


    }


}
