class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = nums[0];
      
        while (low <= high) {
            int mid = low + ((high-low) / 2);
            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
            result = Math.min(result, nums[mid]);
        }
      
        return result;
    }
}
