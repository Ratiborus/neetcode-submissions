class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch(c) {
                case '(': 
                    stack.push(c);
                    break;
                case ')':
                    if (validPrevious(stack,'(')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{': 
                    stack.push(c);
                    break;
                case '}':
                    if (validPrevious(stack, '{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ']':
                    if (validPrevious(stack, '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    private boolean validPrevious(Stack<Character> s, char sign) {
        return !s.isEmpty() && s.peek() == sign;
    }
}
