class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSums = new long[n];
        prefixSums[0] = chalk[0];
        for (int i = 1; i < n; i++)
            prefixSums[i] = prefixSums[i - 1] + chalk[i];
        long remainder = ((long) k) % prefixSums[n - 1];
        for (int i = 0; i < n; i++) {
            if (prefixSums[i] > remainder)
                return i;
        }
        return -1;
    }
}