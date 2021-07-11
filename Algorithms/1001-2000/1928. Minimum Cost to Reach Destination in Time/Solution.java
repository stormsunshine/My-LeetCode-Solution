class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] times = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(times[i], Integer.MAX_VALUE);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], time = edge[2];
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            if (time <= maxTime && time < times[x][y]) {
                times[x][y] = time;
                times[y][x] = time;
            }
        }
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < n; i++)
            map[i] = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (times[i][j] != Integer.MAX_VALUE) {
                    map[i].put(j, times[i][j]);
                    map[j].put(i, times[i][j]);
                }
            }
        }
        int[][] costs = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        costs[0][0] = passingFees[0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] indexTimeCost1, int[] indexTimeCost2) {
                if (indexTimeCost1[2] != indexTimeCost2[2])
                    return indexTimeCost1[2] - indexTimeCost2[2];
                else
                    return indexTimeCost1[1] - indexTimeCost2[1];
            }
        });
        priorityQueue.offer(new int[]{0, 0, passingFees[0]});
        while (!priorityQueue.isEmpty()) {
            int[] indexTimeCost = priorityQueue.poll();
            int index = indexTimeCost[0], time = indexTimeCost[1], cost = indexTimeCost[2];
            Map<Integer, Integer> nextMap = map[index];
            for (Map.Entry<Integer, Integer> entry : nextMap.entrySet()) {
                int nextIndex = entry.getKey(), nextTime = entry.getValue();
                int totalTime = time + nextTime;
                if (totalTime <= maxTime) {
                    int totalCost = cost + passingFees[nextIndex];
                    if (totalCost < costs[nextIndex][totalTime]) {
                        costs[nextIndex][totalTime] = totalCost;
                        priorityQueue.offer(new int[]{nextIndex, totalTime, totalCost});
                    }
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= maxTime; i++)
            minCost = Math.min(minCost, costs[n - 1][i]);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}