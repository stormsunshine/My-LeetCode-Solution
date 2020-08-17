class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        Map<Integer, List<Integer>> roadMap = new HashMap<Integer, List<Integer>>();
        for (int[] road : roads) {
            int city0 = road[0], city1 = road[1];
            List<Integer> list0 = roadMap.getOrDefault(city0, new ArrayList<Integer>());
            List<Integer> list1 = roadMap.getOrDefault(city1, new ArrayList<Integer>());
            list0.add(city1);
            list1.add(city0);
            roadMap.put(city0, list0);
            roadMap.put(city1, list1);
        }
        int pathCount = targetPath.length;
        int[][] dp = new int[pathCount][n];
        for (int i = 0; i < pathCount; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        int[][] paths = new int[pathCount][n];
        Arrays.fill(paths[0], -1);
        for (int i = 0; i < n; i++)
            dp[0][i] = names[i].equals(targetPath[0]) ? 0 : 1;
        for (int i = 1; i < pathCount; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] == Integer.MAX_VALUE)
                    continue;
                List<Integer> list = roadMap.getOrDefault(j, new ArrayList<Integer>());
                for (int k : list) {
                    if (dp[i][k] > dp[i - 1][j] + (names[k].equals(targetPath[i]) ? 0 : 1)) {
                        dp[i][k] = dp[i - 1][j] + (names[k].equals(targetPath[i]) ? 0 : 1);
                        paths[i][k] = j;
                    }
                }
            }
        }
        int minDistance = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (minDistance > dp[pathCount - 1][i]) {
                minDistance = dp[pathCount - 1][i];
                minIndex = i;
            }
        }
        List<Integer> mostSimilarPath = new ArrayList<Integer>();
        for (int i = pathCount - 1; i >= 0; i--) {
            mostSimilarPath.add(minIndex);
            minIndex = paths[i][minIndex];
        }
        Collections.reverse(mostSimilarPath);
        return mostSimilarPath;
    }
}