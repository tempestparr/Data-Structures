package MinHeap;

public class MinHeap {

    private int[] heap;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        heap[0] = 0;
    }

    public void insert(int n) {
        heap[heap[0] + 1] = n;
        heap[0]++;

        int currIndex = heap[0];
        int parentIndex = parentOf(currIndex);

        while (currIndex != 1 && (heap[currIndex] < heap[parentIndex])) {
            int temp = heap[currIndex];
            heap[currIndex] = heap[parentIndex];
            heap[parentIndex] = temp;
            currIndex = parentIndex;
            parentIndex = parentOf(currIndex);
        }
    }

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


    public static void heapify(int[] data) {
        // last index in the array
        int end = data[0];
        int start = parentOf(end);

        while (start >= 1) {
            // sift down the node at index start to the proper place
            // such that all nodes below the start index are in heap
            // order
            siftDown(data, start, end);
            // decrement to the next lowest parent node
            start--;
        }
        // after sifting down the root all nodes/elements
        //  are in heap order
    }

    public static void siftDown(int[] data, int start, int end) {
        int root = start;
        // while the root has at least one child
        while (leftChildOf(root) <= end) {
            int child = leftChildOf(root);
            // take the smallest of the left or right child
            if (child + 1 <= end && data[child] > data[child + 1]) {
                // then point to the right child instead
                child = child + 1;
            }

            // swap the child with root if child is greater
            if (data[root] > data[child]) {
                // out of min-heap order
                int temp = data[root];
                data[root] = data[child];
                data[child] = temp;

                // return the swapped root to test against its new children
                root = child;
            } else {
                return;
            }
        } // End while
    }

    private static int parentOf(int i) {
        return i / 2;
    }

    private static int rightChildOf(int i) {
        return 2 * i + 1;
    }

    private static int leftChildOf(int i) {
        return 2 * i;
    }

    public void printHeap() {
        for (int i = 1; i <= heap[0]; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    public void printFullHeap() {
        for (int i = 1; i <= heap.length - 1; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
