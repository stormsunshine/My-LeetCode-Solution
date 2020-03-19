class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int length = quality.length;
        int[][] qualityWageArray = new int[length][2];
        for (int i = 0; i < length; i++) {
            qualityWageArray[i][0] = quality[i];
            qualityWageArray[i][1] = wage[i];
        }
        Arrays.sort(qualityWageArray, new Comparator<int[]>() {
            public int compare(int[] qualityWage1, int[] qualityWage2) {
                return qualityWage1[1] * qualityWage2[0] - qualityWage1[0] * qualityWage2[1];
            }
        });
        double ratio = 0;
        int totalQuality = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < K; i++) {
            int[] qualityWage = qualityWageArray[i];
            int curQuality = qualityWage[0], curWage = qualityWage[1];
            totalQuality += curQuality;
            priorityQueue.offer(curQuality);
            double curRatio = 1.0 * curWage / curQuality;
            ratio = Math.max(ratio, curRatio);
        }
        double minCost = totalQuality * ratio;
        for (int i = K; i < length; i++) {
            int prevQuality = priorityQueue.poll();
            totalQuality -= prevQuality;
            int[] qualityWage = qualityWageArray[i];
            int curQuality = qualityWage[0], curWage = qualityWage[1];
            totalQuality += curQuality;
            priorityQueue.offer(curQuality);
            double curRatio = 1.0 * curWage / curQuality;
            ratio = Math.max(ratio, curRatio);
            double curCost = totalQuality * ratio;
            minCost = Math.min(minCost, curCost);
        }
        return minCost;
    }
}