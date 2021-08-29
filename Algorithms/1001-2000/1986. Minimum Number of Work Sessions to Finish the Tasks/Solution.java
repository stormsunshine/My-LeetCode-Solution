class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int total = 0;
        int length = tasks.length;
        for (int i = 0; i < length; i++)
            total += tasks[i];
        int maxIndex = length - 1;
        int sessions = 0;
        while (total > 0) {
            int maxTask = tasks[maxIndex];
            tasks[maxIndex] = 0;
            total -= maxTask;
            int maxTime = getMaxTime(tasks, sessionTime - maxTask);
            total -= maxTime;
            sessions++;
            while (maxIndex >= 0 && tasks[maxIndex] == 0)
                maxIndex--;
        }
        return sessions;
    }

    public int getMaxTime(int[] tasks, int sessionTime) {
        int length = tasks.length;
        int[][] dp = new int[length + 1][sessionTime + 1];
        for (int i = 0; i < length; i++) {
            int task = tasks[i];
            for (int j = 0; j <= sessionTime; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j >= task)
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - task] + task);
            }
        }
        int maxTime = dp[length][sessionTime];
        int temp = maxTime;
        boolean[] removed = new boolean[length];
        for (int i = length; i > 0; i--) {
            if (temp >= tasks[i - 1] && dp[i][temp] == dp[i - 1][temp - tasks[i - 1]] + tasks[i - 1]) {
                temp -= tasks[i - 1];
                removed[i - 1] = true;
            }
        }
        for (int i = 0; i < length; i++) {
            if (removed[i])
                tasks[i] = 0;
        }
        return maxTime;
    }
}