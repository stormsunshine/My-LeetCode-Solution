class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int[] counts = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = length - 1; i >= 0; i--) {
            int height = heights[i];
            while (!stack.isEmpty()) {
                int prevHeight = stack.peek();
                counts[i]++;
                if (prevHeight <= height)
                    stack.pop();
                else
                    break;
            }
            stack.push(height);
        }
        return counts;
    }
}