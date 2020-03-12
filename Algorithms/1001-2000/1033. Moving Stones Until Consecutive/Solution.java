class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int left = Math.min(Math.min(a, b), c);
        int right = Math.max(Math.max(a, b), c);
        int mid = a + b + c - left - right;
        int min = 2;
        if (mid - left == 1 && right - mid == 1)
            min = 0;
        else if (mid - left <= 2 || right - mid <= 2)
            min = 1;
        int max = right - left - 2;
        return new int[]{min, max};
    }
}