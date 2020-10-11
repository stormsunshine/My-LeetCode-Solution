class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int[] road : roads) {
            int city0 = road[0], city1 = road[1];
            Set<Integer> set0 = map.getOrDefault(city0, new HashSet<Integer>());
            Set<Integer> set1 = map.getOrDefault(city1, new HashSet<Integer>());
            set0.add(city1);
            set1.add(city0);
            map.put(city0, set0);
            map.put(city1, set1);
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set0 = map.getOrDefault(i, new HashSet<Integer>());
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set1 = map.getOrDefault(j, new HashSet<Integer>());
                int rank = set0.size() + set1.size();
                if (set0.contains(j))
                    rank--;
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}