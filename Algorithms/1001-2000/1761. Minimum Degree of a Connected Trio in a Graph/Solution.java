class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1];
            Set<Integer> set0 = map.getOrDefault(node0, new HashSet<Integer>());
            Set<Integer> set1 = map.getOrDefault(node1, new HashSet<Integer>());
            set0.add(node1);
            set1.add(node0);
            map.put(node0, set0);
            map.put(node1, set1);
        }
        int minDegree = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = map.getOrDefault(i, new HashSet<Integer>());
            if (set.size() < 2)
                continue;
            List<Integer> list = new ArrayList<Integer>(set);
            int size = list.size();
            for (int j = 0; j < size; j++) {
                int node1 = list.get(j);
                Set<Integer> set1 = map.get(node1);
                for (int k = j + 1; k < size; k++) {
                    int node2 = list.get(k);
                    if (set1.contains(node2)) {
                        Set<Integer> set2 = map.get(node2);
                        int count = set.size() + set1.size() + set2.size() - 6;
                        minDegree = Math.min(minDegree, count);
                    }
                }
            }
        }
        return minDegree == Integer.MAX_VALUE ? -1 : minDegree;
    }
}