class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return List.of();
        }
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // sort nums so that dupes can be skipped
        int target = 0;
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] > 0) {
                break; // all remaining numbers are > 0
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue; // skip duplicate numbers
            }

            int l = i + 1;
            int r = nums.length-1;
            while (l < r) { 
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
                else if (sum > 0) {
                    r--; 
                }    
                else {
                    l++; // sum too small, increment l
                }
                // shift left pointer until no dupes
                while (l < r && nums[l] == nums[l-1]) {
                    l++;
                }
            }
        }
        return results;
    }
}
