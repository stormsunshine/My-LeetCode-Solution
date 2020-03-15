class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MODULO = 1000000007;
        int[][] speedEfficiencyArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            speedEfficiencyArray[i][0] = speed[i];
            speedEfficiencyArray[i][1] = efficiency[i];
        }
        Arrays.sort(speedEfficiencyArray, new Comparator<int[]>() {
            public int compare(int[] speedEfficiency1, int[] speedEfficiency2) {
                if (speedEfficiency1[1] != speedEfficiency2[1])
                    return speedEfficiency2[1] - speedEfficiency1[1];
                else
                    return speedEfficiency2[0] - speedEfficiency1[0];
            }
        });
        long maxPerformance = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        long speedSum = 0;
        int minEfficiency = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            int[] speedEfficiency = speedEfficiencyArray[i];
            int curSpeed = speedEfficiency[0];
            int curEfficiency = speedEfficiency[1];
            priorityQueue.offer(curSpeed);
            speedSum += curSpeed;
            minEfficiency = Math.min(minEfficiency, curEfficiency);
            long curPerformance = speedSum * (long) minEfficiency;
            maxPerformance = Math.max(maxPerformance, curPerformance);
        }
        for (int i = k; i < n; i++) {
            int prevSpeed = priorityQueue.poll();
            speedSum -= prevSpeed;
            int[] speedEfficiency = speedEfficiencyArray[i];
            int curSpeed = speedEfficiency[0];
            int curEfficiency = speedEfficiency[1];
            priorityQueue.offer(curSpeed);
            speedSum += curSpeed;
            minEfficiency = Math.min(minEfficiency, curEfficiency);
            long curPerformance = speedSum * (long) minEfficiency;
            maxPerformance = Math.max(maxPerformance, curPerformance);
        }
        return (int) (maxPerformance % MODULO);
    }
}