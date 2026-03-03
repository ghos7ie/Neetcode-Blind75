// LOWKEY can't think of thison my own
class Solution {
    private List<List<Integer>> results;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, target, 0, 0, new ArrayList<>());
        return results;
    }

    public void backtrack(int[] nums, int target, int i, int total, List<Integer> curr) {
        if (total == target) {
            results.add(new ArrayList<>(curr)); // stops for current num if it hits target
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) { // stops if exploration exceeds
                return;
            }
            curr.add(nums[j]);
            backtrack(nums, target, j, total + nums[j], curr); // at each num, explore all the way in
            curr.remove(curr.size() - 1);
        }
    }
}
