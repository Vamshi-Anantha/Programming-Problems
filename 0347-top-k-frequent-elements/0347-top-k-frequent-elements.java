// 2nd approach
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        int[] freq = new int[max - min + 1];

        for (int n : nums) {
            freq[n - min]++;
        }

        ArrayList<Integer>[] freqArr = new ArrayList[nums.length+1];

        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (freqArr[freq[i]] == null) {
                    freqArr[freq[i]] = new ArrayList<Integer>();
                }
                freqArr[freq[i]].add(i + min);
            }
        }
        
        int[] res = new int[k];

        int kk = 0;
        for (int i=freqArr.length-1; i>=0; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size(); j++) {
                    res[kk] = freqArr[i].get(j);
                    kk++;

                    if (kk >= k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
// 3rd approach
// import java.util.*;

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Step 1: Count the frequency of each element in the array
//         Map<Integer, Integer> freqMap = new HashMap<>();
//         for (int num : nums) {
//             freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//         }

//         // Step 2: Use a min-heap to store the top k frequent elements
//         // The heap will store pairs of (element, frequency)
//         PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
//             new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

//         // Step 3: Add all elements to the min-heap, but ensure its size is at most k
//         for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
//             minHeap.add(entry);
//             if (minHeap.size() > k) {
//                 minHeap.poll();  // Remove the element with the smallest frequency
//             }
//         }

//         // Step 4: Extract the top k elements from the heap
//         int[] result = new int[k];
//         for (int i = 0; i < k; i++) {
//             result[i] = minHeap.poll().getKey();  // Get the element (not frequency)
//         }

//         return result;
//     }
// }
