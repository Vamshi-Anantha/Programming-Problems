class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>ans=new ArrayList<>();
        int l=s.length();
        if(l<11||l>10000)return ans;
        String temp;
        HashSet<String>set=new HashSet<>();
        int start=0;
        for(int i=10;i<=l;i++){
            temp=s.substring(start++,i);
            if(!set.add(temp)&&!ans.contains(temp)){
                ans.add(temp);
            }
        }
        return ans;
    }
}

// import java.util.*;

// class Solution {
//     public List<String> findRepeatedDnaSequences(String s) {
//         int L = 10;  // Length of substring
//         int base = 4; // Using base-4 encoding
//         int mask = (1 << (2 * L)) - 1; // Bitmask for rolling hash (20 bits for 10 letters)
        
//         if (s.length() < L) return new ArrayList<>();

//         // Encoding map: 'A' = 0, 'C' = 1, 'G' = 2, 'T' = 3
//         Map<Character, Integer> map = new HashMap<>();
//         map.put('A', 0);
//         map.put('C', 1);
//         map.put('G', 2);
//         map.put('T', 3);

//         int hash = 0;
//         Set<Integer> seenHashes = new HashSet<>();
//         Set<String> result = new HashSet<>();

//         for (int i = 0; i < s.length(); i++) {
//             // Add new character (shift left by 2 bits and add mapped value)
//             hash = ((hash << 2) | map.get(s.charAt(i))) & mask;

//             // Start checking when we reach 10 characters
//             if (i >= L - 1) {
//                 String sub = s.substring(i - L + 1, i + 1);
//                 if (seenHashes.contains(hash)) {
//                     result.add(sub);
//                 }
//                 seenHashes.add(hash);
//             }
//         }

//         return new ArrayList<>(result);
//     }
// }
