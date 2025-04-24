// 1st approach
class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                ans++;
            }
            n = n / 2; // or use n >>> 1 for unsigned shift
        }
        return ans;
    }
}


// 2nd approach
// class Solution {
//     public int hammingWeight(int n) {
//         int count = 0;
//         while (n != 0) {
//             count += n & 1;  // Add 1 if the last bit is 1
//             n >>>= 1;        // Unsigned right shift to move to the next bit
//         }
//         return count;
//     }
// }
