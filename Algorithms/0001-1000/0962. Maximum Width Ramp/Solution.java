class Solution {
    public int maxWidthRamp(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        int maxWidth = 0;
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Integer> indicesStack = new Stack<Integer>();
        numStack.push(A[0]);
        indicesStack.push(0);
        int length = A.length;
        for (int i = 1; i < length; i++) {
            int num = A[i];
            if (numStack.isEmpty() || num < numStack.peek()) {
                numStack.push(num);
                indicesStack.push(i);
            } else {
                Stack<Integer> tempNumStack = new Stack<Integer>();
                Stack<Integer> tempIndicesStack = new Stack<Integer>();
                while (!numStack.isEmpty() && num >= numStack.peek()) {
                    tempNumStack.push(numStack.pop());
                    tempIndicesStack.push(indicesStack.pop());
                }
                int prevIndex = tempIndicesStack.peek();
                maxWidth = Math.max(maxWidth, i - prevIndex);
                while (!tempNumStack.isEmpty()) {
                    numStack.push(tempNumStack.pop());
                    indicesStack.push(tempIndicesStack.pop());
                }
            }
        }
        return maxWidth;
    }
}