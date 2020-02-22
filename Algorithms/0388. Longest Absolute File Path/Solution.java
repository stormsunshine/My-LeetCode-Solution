class Solution {
    public int lengthLongestPath(String input) {
        String[] array = input.split("\n");
        int maxLength = 0;
        int level = 0;
        Stack<String> strStack = new Stack<String>();
        Stack<Integer> levelStack = new Stack<Integer>();
        Stack<Integer> lengthStack = new Stack<Integer>();
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            String str = array[i];
            int length = str.length();
            while (level < length && str.charAt(level) == '\t')
                level++;
            while (level > 0 && str.charAt(level - 1) != '\t')
                level--;
            length -= level;
            while (!levelStack.isEmpty() && levelStack.peek() >= level) {
                strStack.pop();
                levelStack.pop();
                lengthStack.pop();
            }
            int totalLength = lengthStack.isEmpty() ? length : lengthStack.peek() + 1 + length;
            strStack.push(str);
            levelStack.push(level);
            lengthStack.push(totalLength);
            if (str.indexOf('.') >= 0)
                maxLength = Math.max(maxLength, totalLength);
        }
        return maxLength;
    }
}