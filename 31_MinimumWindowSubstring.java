class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> sCount = new HashMap<>();

        int[] resultString = {-1, -1}; // replace with l and r
        int resultLength = Integer.MAX_VALUE; // since we want minimum
        
        int required = tCount.size();
        int have = 0;
        
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1); 

            if (tCount.containsKey(c) && sCount.get(c).equals(tCount.get(c))) {
                have++; // only increment when character count match
            }

            while (have == required) {
                int window = r - l + 1;
                if (window < resultLength) { // if new result is shorter than existing
                    resultLength = window;
                    resultString[0] = l;
                    resultString[1] = r;
                }

                // reduce left side
                char cLeft = s.charAt(l);
                sCount.put(cLeft, sCount.get(cLeft) - 1);
                if (tCount.containsKey(cLeft) && sCount.get(cLeft) <  tCount.get(cLeft)) {
                    have--; // decrement since not enouhg
                }
                l++; // reduce
            }
        }
        if (resultLength == Integer.MAX_VALUE) {
            return "";
        }else {
            return s.substring(resultString[0], resultString[1] + 1);
        }
    }
}
