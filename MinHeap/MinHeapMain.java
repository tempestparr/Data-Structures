package MinHeap;

import java.util.Arrays;

public class MinHeapMain {

    public static void main(String[] args) {
        MinHeap m = new MinHeap(12);
        m.insert(3);
        m.insert(8);
        m.insert(5);
        m.insert(4);
        m.insert(3);
        m.insert(9);
        m.insert(34);
        m.insert(56);
        m.insert(33);
        m.insert(7);
        m.insert(1);
        
        m.printHeap();
        
        
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        System.out.println(m.getMin());
        
        m.printHeap();
        m.printFullHeap();
        
        int[] data = {9, 1, 3, 36, 2, 19, 25, 100, 17, 0};

        m.heapify(data);   
        System.out.println(Arrays.toString(data));
    }
    
}
