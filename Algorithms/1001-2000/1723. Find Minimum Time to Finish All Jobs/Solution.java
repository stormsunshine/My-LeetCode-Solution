class Solution {
    int minTime = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] times = new int[k];
        int length = jobs.length;
        for (int i = 1; i <= k; i++)
            times[i - 1] = jobs[length - i];
        backtrack(jobs, k, length - k - 1, times);
        return minTime;
    }

    public void backtrack(int[] jobs, int k, int index, int[] times) {
        if (index < 0) {
            int max = 0;
            for (int i = 0; i < k; i++)
                max = Math.max(max, times[i]);
            minTime = Math.min(minTime, max);
        } else {
            int job = jobs[index];
            for (int i = 0; i < k; i++) {
                if (times[i] + job < minTime) {
                    times[i] += job;
                    backtrack(jobs, k, index - 1, times);
                    times[i] -= job;
                }
            }
        }
    }
}