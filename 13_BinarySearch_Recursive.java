class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        return binarySearch(nums, target, 0, length - 1 );
        
    }


    int binarySearch(int[] nums, int target, int low,int high ){ 
        if (high >= low) { 
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return binarySearch(nums, target, low, mid - 1);
            }
            else {
                return binarySearch(nums, target, mid + 1, high);
            }
        }
        return -1;
    }
}
