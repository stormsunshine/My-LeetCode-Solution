class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int leftMost = -1, rightMost = -1;
        if (left.length > 0)
            leftMost = left[left.length - 1];
        if (right.length > 0)
            rightMost = right[0];
        if (leftMost < 0 && rightMost < 0)
            return 0;
        if (leftMost < 0)
            return n - rightMost;
        else if (rightMost < 0)
            return leftMost;
        else
            return Math.max(n - rightMost, leftMost);
    }
}