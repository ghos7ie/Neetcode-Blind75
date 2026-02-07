class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pt1 = 0;
        int pt2 = numbers.length - 1;

        while (pt1 < pt2) {
            int sum = numbers[pt1] + numbers[pt2];
            if (sum == target) {
                return new int[] { pt1 + 1, pt2 + 1};
            }

            if (sum < target ) {
                pt1++;
            }
            else if (sum > target) {
                pt2--;
            }
        }
        return new int[] {};
    }
}
