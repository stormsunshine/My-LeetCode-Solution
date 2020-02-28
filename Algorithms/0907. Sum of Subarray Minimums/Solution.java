class Solution {
    public int sumSubarrayMins(int[] A) {
        final int MODULO = 1000000007;
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Integer> countStack = new Stack<Integer>();
        int sum = 0;
        int product = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int num = A[i];
            int count = 1;
            while (!numStack.isEmpty() && numStack.peek() >= num) {
                int prevNum = numStack.pop();
                int prevCount = countStack.pop();
                count += prevCount;
                product -= prevNum * prevCount;
            }
            numStack.push(num);
            countStack.push(count);
            product += num * count;
            sum = (sum + product) % MODULO;
        }
        return sum;
    }
}