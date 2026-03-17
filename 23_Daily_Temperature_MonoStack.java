class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            result[i] = 0;
        }
        // track temps that have not seen a warmer day
        Stack<int[]> stack = new Stack<>(); // [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            // check if temperatures[i] is more than stack
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                // enters if stack isn't empty and currenet temp is more than those in the stack
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            // push into stack to find next
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
