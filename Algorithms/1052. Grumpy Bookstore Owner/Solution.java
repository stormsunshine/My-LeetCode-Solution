class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0;
        int length = customers.length;
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0)
                satisfied += customers[i];
        }
        int unsatisfiedWindow = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1)
                unsatisfiedWindow += customers[i];
        }
        int maxUnsatisfiedWindow = unsatisfiedWindow;
        for (int i = X; i < length; i++) {
            int prevIndex = i - X;
            if (grumpy[prevIndex] == 1)
                unsatisfiedWindow -= customers[prevIndex];
            if (grumpy[i] == 1)
                unsatisfiedWindow += customers[i];
            maxUnsatisfiedWindow = Math.max(maxUnsatisfiedWindow, unsatisfiedWindow);
        }
        return satisfied + maxUnsatisfiedWindow;
    }
}