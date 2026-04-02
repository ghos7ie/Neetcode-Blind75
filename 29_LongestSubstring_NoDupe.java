class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>(); // character, index
        
        int l = 0;
        int result = 0;

        for (int r = 0; r < s.length(); r++) {
            if (hm.containsKey(s.charAt(r))){
                l = Math.max(hm.get(s.charAt(r)) + 1, l);
            }

            hm.put(s.charAt(r), r);
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
