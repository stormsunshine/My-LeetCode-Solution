class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] waitingDays = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> indicesStack = new Stack<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && stack.peek() < temperature) {
                int prevTemperature = stack.pop();
                int index = indicesStack.pop();
                waitingDays[index] = i - index;
            }
            stack.push(temperature);
            indicesStack.push(i);
        }
        return waitingDays;
    }
}