public class Solution {
    public int numTrees(int n) {
        int[] counts = new int[n + 1];
        if (n == 0)
            return 1;
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 2; i <= n; i++) {
            counts[i] = 0;
            for (int j = 0; j < i; j++)
                counts[i] += counts[j] * counts[i - j - 1];
        }
        return counts[n];
    }
}