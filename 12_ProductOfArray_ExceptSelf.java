class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int [] result = new int[length];
        int [] prefix = new int[length];
        int [] postfix = new int[length];
        
        // initialise the respective ends
        prefix[0] = 1;
        postfix[length - 1] = 1;

        // get all prefix products
        for (int i = 1; i < length; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        // get all postfix products
        for (int i = length - 2; i >= 0; i--) {
            postfix[i] = nums[i+1] * postfix[i+1];
        }

        // get actual products
        for (int i = 0; i < length; i++) {
            result[i] = prefix[i] * postfix[i];
        }

        return result;
    }
}  
