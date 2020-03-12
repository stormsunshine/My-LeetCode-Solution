class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;
        int rows = arrays.size();
        int[][] minMaxArray = new int[rows][2];
        for (int i = 0; i < rows; i++) {
            List<Integer> row = arrays.get(i);
            int size = row.size();
            int curMin = row.get(0), curMax = row.get(size - 1);
            minMaxArray[i][0] = curMin;
            minMaxArray[i][1] = curMax;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == j)
                    continue;
                maxDistance = Math.max(maxDistance, Math.max(Math.abs(minMaxArray[i][0] - minMaxArray[j][1]), Math.abs(minMaxArray[i][1] - minMaxArray[j][0])));
            }
        }
        return maxDistance;
    }
}