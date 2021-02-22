class Solution {
    int[] ans;
    Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
    Map<Integer, List<Integer>> coprimesMap = new HashMap<Integer, List<Integer>>();
    int[] depths;
    int[] pos = new int[51];

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        ans = new int[n];
        depths = new int[n];
        Arrays.fill(ans, -1);
        Arrays.fill(pos, -1);
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1];
            List<Integer> list0 = edgesMap.getOrDefault(node0, new ArrayList<Integer>());
            List<Integer> list1 = edgesMap.getOrDefault(node1, new ArrayList<Integer>());
            list0.add(node1);
            list1.add(node0);
            edgesMap.put(node0, list0);
            edgesMap.put(node1, list1);
        }
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    List<Integer> list = coprimesMap.getOrDefault(i, new ArrayList<Integer>());
                    list.add(j);
                    coprimesMap.put(i, list);
                }
            }
        }
        depthFirstSearch(nums, 0, -1);
        return ans;
    }

    public void depthFirstSearch(int[] nums, int u, int form) {
        int t = nums[u];
        for (int v : coprimesMap.get(t)) {
            if (pos[v] != -1) {
                if (ans[u] == -1 || depths[ans[u]] < depths[pos[v]])
                    ans[u] = pos[v];
            }
        }
        int p = pos[t];
        pos[t] = u;
        for (int i : edgesMap.get(u)) {
            if (i != form) {
                depths[i] = depths[u] + 1;
                depthFirstSearch(nums, i, u);
            }
        }
        pos[t] = p;
    }

    public int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a >= b)
                a %= b;
            else
                b %= a;
        }
        return a == 0 ? b : a;
    }
}