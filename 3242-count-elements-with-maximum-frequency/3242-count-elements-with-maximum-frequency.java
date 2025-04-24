class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        // Count frequencies and find max frequency
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        int ans = 0;

        // Add up all elements with max frequency
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreq) {
                ans += maxFreq;
            }
        }

        return ans;
    }
}