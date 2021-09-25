package algorithms.LinkList;

import java.util.Stack;

public class IsPalindromeList {

    /**
     * need n extra space
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * need n/2 extra space
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode right = head.next;
        ListNode cur = head;

        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * need O(1) extra space
     * @param head
     * @return
     */
    public static boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null){
            return true;
        } 
        ListNode n1 = head;
        ListNode n2 = head;

        // find mid node
        while (n2.next != null && n2.next.next != null) { 
            // n1 -> mid
            n1 = n1.next;
             // n2 -> end
            n2 = n2.next.next;
        }
        // n1 中点
        // n2 -> right part first node
        n2 = n1.next; 
         // mid.next -> null
        n1.next = null;
        ListNode n3 = null;

        while (n2 != null) {
            n3 = n2.next;
            // next of right node convert
            n2.next = n1; 
             //  n1 move
            n1 = n2;
             // n2 move
            n2 = n3;
        }
        // n3 -> save last node
        n3 = n1; 
        // n2 -> left first node
        n2 = head;

        boolean res = true;

        // check palindrome
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            // left to mid
            n1 = n1.next; 
             // right to mid
            n2 = n2.next;
        }

        n1 = n3.next;
        n3.next = null;
        // recover list
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        // head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(2);
        // head.next.next.next = new ListNode(1);
        // printLinkedList(head);
        // System.out.print(isPalindrome1(head) + " | ");
        // System.out.print(isPalindrome2(head) + " | ");
        // System.out.println(isPalindrome3(head) + " | ");
        // printLinkedList(head);
        System.out.println("=========================");

        // head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(2);
        // head.next.next.next.next = new ListNode(1);
        // printLinkedList(head);
        // System.out.print(isPalindrome1(head) + " | ");
        // System.out.print(isPalindrome2(head) + " | ");
        // System.out.println(isPalindrome3(head) + " | ");
        // printLinkedList(head);
        // System.out.println("=========================");
    }
}
