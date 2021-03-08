class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        final int FACTOR = 100000;
        int[] degrees = new int[n + 1];
        int[] arr = new int[n + 1];
        int length = queries.length;
        int[] pairs = new int[length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] edge : edges) {
            int u = Math.min(edge[0], edge[1]);
            int v = Math.max(edge[0], edge[1]);
            degrees[u]++;
            degrees[v]++;
            int key = u * FACTOR + v;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 1; i <= n; i++)
            arr[i] = degrees[i];
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            int low = 1, high = n;
            while (low < high) {
                while (low < high && arr[low] + arr[high] <= queries[i])
                    low++;
                if (low < high)
                    pairs[i] += high - low;
                high--;
            }
            if (pairs[i] != 0) {
                Set<Integer> visited = new HashSet<Integer>();
                for (int[] edge : edges) {
                    int u = Math.min(edge[0], edge[1]);
                    int v = Math.max(edge[0], edge[1]);
                    int key = u * FACTOR + v;
                    if (visited.add(key)) {
                        int pair = degrees[u] + degrees[v] - map.get(key);
                        if (degrees[u] + degrees[v] > queries[i] && pair <= queries[i])
                            pairs[i]--;
                    }
                }
            }
        }
        return pairs;
    }
}