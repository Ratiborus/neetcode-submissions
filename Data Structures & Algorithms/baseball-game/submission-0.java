class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            Optional<Integer> d = getDigit(s);
            if (!d.isEmpty()) {
                stack.push(d.get());
            } else if ("+".equals(s)) {
                int two = stack.pop();
                int one = stack.pop();
                stack.push(one);
                stack.push(two);
                stack.push(one + two);
            } else if ("D".equals(s)) {
                stack.push(stack.peek() * 2);
            } else if ("C".equals(s)){
                stack.pop();
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private Optional<Integer> getDigit(String s) {
        if (s.isEmpty()) {
            return Optional.empty();
        }
        try {
            int res = Integer.parseInt(s);
            return Optional.of(res);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}