class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); // create hashmap for num to count
        List<Integer>[] freq = new List[nums.length + 1]; // to frequency from least to max

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>(); // initialise each slot
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1); // get the slot and +1
        }

        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            freq[e.getValue()].add(e.getKey()); // set each n into freq table
        }

        int[] result = new int[k]; // possible to have all numbers appear once
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n: freq[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
