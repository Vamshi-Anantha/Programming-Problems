class Solution {
    public boolean rotateString(String s, String goal) {
        int a = s.length();
        int b = goal.length();
        if(a != b) return false;
        return (s + s).contains(goal);
    }
}