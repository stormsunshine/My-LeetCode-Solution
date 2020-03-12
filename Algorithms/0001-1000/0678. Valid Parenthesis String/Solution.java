class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> parenthesesStack = new Stack<Integer>();
        Queue<Integer> asterisksQueue = new LinkedList<Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '*')
                asterisksQueue.offer(i);
            else if (c == '(')
                parenthesesStack.push(i);
            else if (c == ')') {
                if (!parenthesesStack.isEmpty())
                    parenthesesStack.pop();
                else if (!asterisksQueue.isEmpty())
                    asterisksQueue.poll();
                else
                    return false;
            }
        }
        if (parenthesesStack.isEmpty())
            return true;
        else {
            Stack<Integer> newParenthesesStack = new Stack<Integer>();
        	while (!parenthesesStack.isEmpty())
        		newParenthesesStack.push(parenthesesStack.pop());
            while (!newParenthesesStack.isEmpty() && !asterisksQueue.isEmpty()) {
                int parenthesisIndex = newParenthesesStack.peek();
                int asteriskIndex = asterisksQueue.poll();
                if (parenthesisIndex < asteriskIndex)
                	newParenthesesStack.pop();
            }
            return newParenthesesStack.isEmpty();
        }
    }
}