class Solution {
    public int minCost(String s, int[] cost) {
        int totalCost = 0;
        char prev = s.charAt(0);
        int maxCost = cost[0];
        int curTotalCost = cost[0];
        int length = s.length();
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            int curCost = cost[i];
            if (c == prev) {
                maxCost = Math.max(maxCost, curCost);
                curTotalCost += curCost;
            } else {
                totalCost += curTotalCost - maxCost;
                prev = c;
                maxCost = curCost;
                curTotalCost = curCost;
            }
        }
        totalCost += curTotalCost - maxCost;
        return totalCost;
    }
}