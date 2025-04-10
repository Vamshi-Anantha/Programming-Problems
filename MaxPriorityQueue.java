import java.util.ArrayList;

public class MaxPriorityQueue {
    private ArrayList<Integer> pq;

    public MaxPriorityQueue() {
        pq = new ArrayList<>();
    }

    public int getSize() {
        return pq.size();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public int getMax() {
        if (isEmpty()) {
            System.out.println("Empty priority Queue.");
            return -1;
        }
        return pq.get(0);
    }

    public void insert(int val) {
        pq.add(val);
        int childIndex = pq.size() - 1;

        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (pq.get(childIndex) > pq.get(parentIndex)) {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
            } else {
                return;
            }
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty priority Queue.");
            return -1;
        }

        int max = pq.get(0);
        int last = pq.remove(pq.size() - 1);

        if (!pq.isEmpty()) {
            pq.set(0, last);
            heapifyDown(0);
        }

        return max;
    }

    private void heapifyDown(int parentIndex) {
        int size = pq.size();
        while (parentIndex < size) {
            int left = 2 * parentIndex + 1;
            int right = 2 * parentIndex + 2;
            int largest = parentIndex;

            if (left < size && pq.get(left) > pq.get(largest)) {
                largest = left;
            }

            if (right < size && pq.get(right) > pq.get(largest)) {
                largest = right;
            }

            if (largest != parentIndex) {
                swap(parentIndex, largest);
                parentIndex = largest;
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
        MaxPriorityQueue pq = new MaxPriorityQueue();
        pq.insert(10);
        pq.insert(20);
        pq.insert(30);
        pq.insert(10);
        pq.insert(20);
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(20);
        pq.insert(30);
        pq.insert(50);
        pq.insert(50);

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }
}
