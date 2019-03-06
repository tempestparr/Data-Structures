package LinkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedNode a = new LinkedNode(1);
//        System.out.printf("%d\n", a.value);
       
        
        LinkedList b = new LinkedList(3);        
        b.add(new LinkedNode(1));
        b.add(new LinkedNode(1));
//        b.add(new LinkedNode(5));
//        b.add(new LinkedNode(10));
//        b.add(new LinkedNode(2));
//        b.add(new LinkedNode(1));
        b.printLinkedList();
        
//        LinkedList c = new LinkedList(5);
//        c.add(new LinkedNode(7));
//        c.add(new LinkedNode(9));
//        c.printLinkedList();
//
//        LinkedList d = b.mergeSortedLists(c);
//        d.printLinkedList();
        //System.out.printf("%d\n", b.indexOfNode(5));
//        c.concatenate(b);
//        c.printLinkedList();
//        c.reverse();
//        c.printLinkedList();

//        b.removeDups();
//        b.printLinkedList();

//        b.kthToLast(0);
        
        partition(b.head, 3);
        b.printLinkedList();
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
}
