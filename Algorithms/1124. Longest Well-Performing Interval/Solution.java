class Solution {
    public int longestWPI(int[] hours) {
        int length = hours.length;
        int[] scores = new int[length + 1];
        scores[0] = 0;
        for (int i = 1; i <= length; i++) {
            int curScore = hours[i - 1] > 8 ? 1 : -1;
            scores[i] = scores[i - 1] + curScore;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= length; i++) {
            if (stack.isEmpty() || scores[stack.peek()] > scores[i])
                stack.push(i);
        }
        int maxLength = 0;
        int index = length;
        while (!stack.isEmpty() && index >= 0) {
            if (scores[index] > scores[stack.peek()]) {
                maxLength = Math.max(maxLength, index - stack.peek());
                stack.pop();
                index++;
            }
            index--;
        }
        return maxLength;
    }
}