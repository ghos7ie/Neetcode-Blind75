class Solution {
    public boolean isAnagram(String s, String t) {
       
       // case 1 : diff length
       if (s.length() != t.length()) {
        return false;
       }

       int[] alphaCount = new int[26]; // 26 letters
       for (int i = 0; i < s.length(); i++) {
        alphaCount[s.charAt(i) - 'a'] ++; // get alphabet position then increment
        alphaCount[t.charAt(i) - 'a'] --; // similar, but decrement
       }

       for (int val : alphaCount) {
        if (val != 0) {
            return false;
        }
       }

       return true;      

    }
}
