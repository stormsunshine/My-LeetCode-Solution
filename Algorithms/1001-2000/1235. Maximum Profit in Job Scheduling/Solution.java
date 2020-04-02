class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int length = startTime.length;
        int[][] jobs = new int[length][3];
        for (int i = 0; i < length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] job1, int[] job2) {
                return job1[1] - job2[1];
            }
        });
        int[] prevJobs = new int[length];
        for (int i = 0; i < length; i++)
            prevJobs[i] = binarySearch(jobs, jobs[i][0]);
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = jobs[0][2];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int prevJob = prevJobs[i];
            if (prevJob >= 0)
                dp[i][1] = Math.max(dp[prevJob][0], dp[prevJob][1]) + jobs[i][2];
            else
                dp[i][1] = jobs[i][2];
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    public int binarySearch(int[][] jobs, int maxEndTime) {
        int low = 0, high = jobs.length - 1;
        while (low <= high) {
            int mid = (high - low + 1) / 2 + low;
            int[] job = jobs[mid];
            if (job[1] > maxEndTime)
                high = mid - 1;
            else {
                if (low == high)
                    break;
                else
                    low = mid;
            }
        }
        return high;
    }
}