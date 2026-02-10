class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        // check from l to r
        // if is starting bracket, add to stack
        // if ending bracket, check if top of stack has starting
        for (char c : s.toCharArray()) {
            // if closing - check if can pop
            if (brackets.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == brackets.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
