class Solution {
    public int[] constructArray(int n, int k) {
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++)
            sorted[i] = i + 1;
        int[] arrangement = new int[n];
        int low = 0, high = k;
        for (int i = 0; i <= k; i++) {
            if (i % 2 == 0)
                arrangement[i] = sorted[low++];
            else
                arrangement[i] = sorted[high--];
        }
        for (int i = k + 1; i < n; i++)
            arrangement[i] = sorted[i];
        return arrangement;
    }
}