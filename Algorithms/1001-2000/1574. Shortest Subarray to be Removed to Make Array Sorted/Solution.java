class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        boolean flag = true;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag)
            return 0;
        int minLength = length - 1;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(length - 1);
        for (int i = length - 2; i >= 0; i--) {
            int num = arr[i];
            if (num <= arr[stack.peek()])
                stack.push(i);
            else
                break;
        }
        for (int i = 0; i < length; i++) {
            int num = arr[i];
            if (i > 0 && num < arr[i - 1])
                break;
            while (!stack.isEmpty() && num > arr[stack.peek()])
                stack.pop();
            int next = stack.isEmpty() ? length : stack.peek();
            minLength = Math.min(minLength, next - i - 1);
        }
        stack.clear();
        stack.push(0);
        for (int i = 1; i < length; i++) {
            int num = arr[i];
            if (num >= arr[stack.peek()])
                stack.push(i);
            else
                break;
        }
        for (int i = length - 1; i >= 0; i--) {
            int num = arr[i];
            if (i < length - 1 && num > arr[i + 1])
                break;
            while (!stack.isEmpty() && num < arr[stack.peek()])
                stack.pop();
            int prev = stack.isEmpty() ? -1 : stack.peek();
            minLength = Math.min(minLength, i - prev - 1);
        }
        return minLength;
    }
}