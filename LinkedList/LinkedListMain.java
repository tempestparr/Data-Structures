package LinkedList;

import java.util.*;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedNode a = new LinkedNode(1);
//        System.out.printf("%d\n", a.value);
       
        LinkedList b = new LinkedList(21);
        b.add(new LinkedNode(1));        
        b.add(new LinkedNode(2));
        b.add(new LinkedNode(4));
        b.add(new LinkedNode(7));
        b.add(new LinkedNode(3));
        b.add(new LinkedNode(5));
        b.printLinkedList();
               
        LinkedList c = new LinkedList(7);
        c.add(new LinkedNode(8));        
        b.concatenate(c);
        c.concatenate(b);
        
//        partition(b.head, 3);
//        b.printLinkedList();

//        System.out.println(isPalindrome(b.head));

//        System.out.println(getIntersection(c.head, b.head).value);

        System.out.println(getStartOfLoop(b.head).value);

    }
    
    // Partition a linked list around value n. All values less than n
    // come before values greater than or equal to n. Values equal to n
    // can appear anywhere on the "right side" of the partition. They do
    // not need to be between the left and right.
    public static void partition(LinkedNode head, int n) {
        if (head == null) return;
        LinkedNode curr = head;
        LinkedNode runner = head;
        while (curr != null && runner.next != null) {
            if (curr.value >= n) {
                runner = curr.next;
            
            
                while (runner != null && runner.value >= n) {
                    runner = runner.next;
                }

                int temp = curr.value;
                curr.value = runner.value;
                runner.value = temp;
            }
            curr = curr.next;
        }
    }    
    
    public static boolean isPalindrome(LinkedNode head) {
        if (head == null) throw new NullPointerException("Cannot be null list");
        
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        LinkedNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < length / 2; i++) {
            stack.push(curr.value);
            curr = curr.next;
        }
        
        if (length % 2 == 1) {
            curr = curr.next;
        }
        
        while (curr != null) {
            if (curr.value != stack.pop()) {
                System.out.println(curr.value);
                return false;
            }
            curr = curr.next;
        }
        
        return true;
    }
    
    public static LinkedNode getIntersection(LinkedNode headA, LinkedNode headB) {
        int aLength = 0;
        int bLength = 0;
        LinkedNode a = headA;
        LinkedNode b = headB;
        while (a != null) {
            aLength++;
            a = a.next;
        }
        while (b != null) {
            bLength++;
            b = b.next;
        }
        a = headA;
        b = headB;
        
        int lengthDiff = 0;
        if (aLength > bLength) {
            lengthDiff = aLength - bLength;
            for (int i = 0; i < lengthDiff; i++) {
                a = a.next;
            }
        } else {
            lengthDiff = bLength - aLength;
            for (int i = 0; i < lengthDiff; i++) {
                b = b.next;
            }
        }
        
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        
        return null;
    }
    
    public static LinkedNode getStartOfLoop(LinkedNode head) {
        LinkedNode fast = head;
        LinkedNode slow = head;
        
        while (fast != null && fast.next != null) {
            System.out.println(fast.value);
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                break;
            }
        }
        
        if (fast == null || fast.next == null) return null;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
}
