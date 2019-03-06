package LinkedList;

public class LinkedList {
    public LinkedNode head;
    
    LinkedList (int num) {
        this.head = new LinkedNode(num);
    }
    
    void printLinkedList () {
        if (this.head == null) {
            System.out.println("empty");
            return;
        } else {
            System.out.printf("%d", this.head.value);
        }
        
        LinkedNode current = this.head.next;
        while (current != null) {
            System.out.printf("->%d", current.value);
            current = current.next;
        }
        
        System.out.print("\n");
    }
    
    // adds to tail
    void add (LinkedNode node) {
        if(node.next != null)
            node.next = null;
        
        if (head == null) {
            head = node;
            return;
        }
        
        LinkedNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = node;
    }
    
    void removeTail() {
        if(this.head == null) {
            return;
        }
        
        if(this.head.next == null) {
            this.head = null;
            return;
        }
        
        LinkedNode current = this.head.next;
        LinkedNode previous = this.head;
        
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        
        previous.next = null;
    }
    
    void insertAtIndex(LinkedNode node, int index) {
        LinkedNode current = this.head;
        
        if(index < 0) return;
        
        if(index == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }
        
        for(int i = 0; i < (index - 1); i++) {
            if (current.next == null){
                return;
            }
            current = current.next;
        }
        
        node.next = current.next;
        current.next = node;
    }
    
    void removeAtIndex(int index) {
        LinkedNode current = this.head;
        
        if (this.head == null || index < 0) {
            return;
        }
        
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        
        for (int i = 0; i < (index - 1); i++) {
            if (current.next == null){
                return;
            }
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    int getValueAtIndex(int index) {
        if (this.head == null || index < 0) {
            return -1;
        }
        
        LinkedNode current = this.head;
        
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                return -1;
            }
            current = current.next;
        }
        
        return current.value;
    }
    
    int indexOfNode(int nodeVal) {
        if (this.head == null) {
            return -1;
        }
        
        int index = 0;
        LinkedNode current = this.head;
        
        while (current != null) {
            if (current.value == nodeVal) {
                return index;
            }
            
            current = current.next;
            index++;
        }
        
        return -1;
    }
    
    void concatenate(LinkedList list) {
        if (list.head == null) {
            return;
        }
        
        if (this.head == null) {
            this.head = list.head;
            return;
        }
        
        LinkedNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = list.head;
    }
    
    
    void merge(LinkedList list) {
        if (list.head == null) {
            return;
        }
        
        if (this.head == null) {
            this.head = list.head;
            return;
        }
        
        LinkedNode current1 = this.head;
        LinkedNode current2 = list.head;
        LinkedNode temp;
        
        while (current1 != null && current2 != null && current1 != current2) {
            temp = current2.next;
            
            if (current1.next != null) {
                current2.next = current1.next;
            }
            
            current1.next = current2;
            current1 = current2.next;
            current2 = temp;
        }
    }
    
    LinkedList mergeSortedLists(LinkedList headB) {
        LinkedList headC = new LinkedList(0);
        LinkedNode currC = headC.head;
        LinkedNode currA = this.head;
        LinkedNode currB = headB.head;
        
        while (currA != null && currB != null) {
            if (currA.value >= currB.value) {
                currC.next = currB;
                currB = currB.next;
            } else {
                currC.next = currA;
                currA = currA.next;
            }
            currC = currC.next;
        }
        
        if (currA == null) {
            currC.next = currB;
        } else {
            currC.next = currA;
        }
        headC.head = headC.head.next;
        return headC;
    }
    
    void reverse() {
        if (this.head == null) return;
        
        LinkedNode current = this.head;
        LinkedNode temp = null;
        
        while (temp != current) {
            if (current.next != null) {
                head = current.next;
            }
            
            current.next = temp;
            temp = current;
            current = head;
        }
    }
       
    void getKthToLast(int k) {
        LinkedNode counterNode = this.head;
        LinkedNode returnNode = this.head;
        int numNodes = 0;
        
        while (counterNode != null) {
            counterNode = counterNode.next;
            numNodes++;
            if (k < 2) {
                System.out.println(-1);
                return;
            }
        }
        
        int kPosition = numNodes - k;
        if (kPosition > 0) {
            for (int i = 0; i < kPosition; i++) {
                returnNode = returnNode.next;
            }
        }
        
        System.out.println(returnNode.value);
    }
}
