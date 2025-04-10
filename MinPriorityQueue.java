import java.util.ArrayList;

public class MinPriorityQueue {
    private ArrayList<Integer> pq;

    public MinPriorityQueue() {
        pq = new ArrayList<>();
    }

    public int getSize() {
        return pq.size();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public int getMin() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
            return -1;
        }
        return pq.get(0);
    }

    public void insert(int val) {
        pq.add(val);
        int childIndex = pq.size() - 1;

        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;

            if (pq.get(childIndex) < pq.get(parentIndex)) {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
            } else {
                return;
            }
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty priority queue.");
            return -1;
        }

        int min = pq.get(0);
        int last = pq.remove(pq.size() - 1);

        if (!pq.isEmpty()) {
            pq.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyDown(int parentIndex) {
        int size = pq.size();

        while (parentIndex < size) {
            int leftChild = 2 * parentIndex + 1;
            int rightChild = 2 * parentIndex + 2;
            int smallest = parentIndex;

            if (leftChild < size && pq.get(leftChild) < pq.get(smallest)) {
                smallest = leftChild;
            }

            if (rightChild < size && pq.get(rightChild) < pq.get(smallest)) {
                smallest = rightChild;
            }

            if (smallest != parentIndex) {
                swap(parentIndex, smallest);
                parentIndex = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = pq.get(i);
        pq.set(i, pq.get(j));
        pq.set(j, temp);
    }

    public static void main(String[] args) {
        MinPriorityQueue pq = new MinPriorityQueue();

        pq.insert(10);
        pq.insert(50);
        pq.insert(10);
        pq.insert(50);
        pq.insert(40);
        pq.insert(30);
        pq.insert(20);
        pq.insert(40);
        pq.insert(10);
        pq.insert(10);
        pq.insert(50);
        pq.insert(40);
        pq.insert(30);
        pq.insert(20);
        pq.insert(40);
        pq.insert(10);
        pq.insert(10);
        pq.insert(50);
        pq.insert(40);
        pq.insert(30);
        pq.insert(20);
        pq.insert(40);
        pq.insert(10);
        pq.insert(40);
        pq.insert(30);
        pq.insert(20);
        pq.insert(40);
        pq.insert(10);

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }
}
