class Solution {
    public int characterReplacement(String s, int k) {
        // 
        int maxFreq = 0;
        int l = 0;
        int result = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int r = 0; r < s.length(); r++) { 
            // add character to hm
            // or increment count by 1
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1 ); 
            maxFreq = Integer.max(maxFreq, hm.get(s.charAt(r))); // get the freq of character that appears most

            while ((r - l + 1) - maxFreq > k) { // need to replace more than k characters
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1); 
                l++; // shrink window
            }
            result = Integer.max(result, r - l + 1);
        }
        return result;
    }
}
