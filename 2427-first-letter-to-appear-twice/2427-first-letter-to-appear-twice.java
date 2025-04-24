class Solution {
    public char repeatedCharacter(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = c - 'a';
            if(freq[index]!= 0){
                return s.charAt(i);
            }else{
                freq[index]++;
            }
           

        }
        return ' ';
    }
}