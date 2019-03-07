package MinHeap;

public class MinHeap {

    private int[] heap;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        // heap[0] stores the current size
        heap[0] = 0;
    }

    // insert a value at the end and swap it with its parent if needed
    public void insert(int n) {
        // add the value at the end
        heap[heap[0] + 1] = n;
        
        // increment the current size
        heap[0]++;

        int currIndex = heap[0];
        int parentIndex = parentOf(currIndex);

        // while the inserted value is less than the value of its parent
        // and the inserted value isn't already the root, swap it
        // with its parent
        while (currIndex != 1 && (heap[currIndex] < heap[parentIndex])) {
            int temp = heap[currIndex];
            heap[currIndex] = heap[parentIndex];
            heap[parentIndex] = temp;
            currIndex = parentIndex;
            parentIndex = parentOf(currIndex);
        }
    }

    // return the min node value at the root
    public int getMin() {
        int min = heap[1];

        // swap the last element heap[heap[0]] with the root
        heap[1] = heap[heap[0]];      
        heap[heap[0]] = min;
        heap[0]--;

        int currIndex = 1;
        int rightIndex = rightChildOf(1);
        int leftIndex = leftChildOf(1);

        while (((leftIndex <= heap[0]) && (heap[leftIndex] < heap[currIndex]))
                || ((rightIndex <= heap[0]) && (heap[rightIndex] < heap[currIndex]))) {
            int smallerChild = leftIndex;
            if ((rightIndex <= heap[0]) && (heap[rightIndex] < heap[smallerChild])) {
                smallerChild = rightIndex;
            }
            // swap
            int temp = heap[smallerChild];
            heap[smallerChild] = heap[currIndex];
            heap[currIndex] = temp;

            currIndex = smallerChild;
            rightIndex = rightChildOf(currIndex);
            leftIndex = leftChildOf(currIndex);
        }

        return min;
    }

    // swap values to be in min-heap order
    public static void heapify(int[] data) {
        // last index in the array
        int end = data[0];
        // start at the last parent node
        int start = parentOf(end);

        while (start >= 1) {
            siftDown(data, start, end);
            // decrement to the next lowest parent node
            start--;
        }
    }

    // sift down the node to its correct spot if the children are smaller
    public static void siftDown(int[] data, int start, int end) {
        int root = start;
        // while the root has a valid left child
        while (leftChildOf(root) <= end) {
            // child is the left node
            int child = leftChildOf(root);
            // if right child is valid and smaller, set child to right child
            if (child + 1 <= end && data[child] > data[child + 1]) {
                child = child + 1;
            }

            // if the root is larger than the child, swap the values
            if (data[root] > data[child]) {
                int temp = data[root];
                data[root] = data[child];
                data[child] = temp;

                // return the swapped root to test against its new children
                root = child;
            } else {
                return;
            }
        }
    }
    
    // get the parent index of a node
    private static int parentOf(int i) {
        return i / 2;
    }

    // get the right child of a node
    private static int rightChildOf(int i) {
        return 2 * i + 1;
    }

    // get the left child of a node
    private static int leftChildOf(int i) {
        return 2 * i;
    }

    // print just the data in the heap
    public void printHeap() {
        for (int i = 1; i <= heap[0]; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    // print the entire heap with empty space
    public void printFullHeap() {
        for (int i = 1; i <= heap.length - 1; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
