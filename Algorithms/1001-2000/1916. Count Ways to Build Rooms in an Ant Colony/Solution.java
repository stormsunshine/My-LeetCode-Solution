class Solution {
    static final int MODULO = 1000000007;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            if (prevRoom[i] >= 0)
                degree[prevRoom[i]]++;
        }
        int[] fac = new int[n + 1];
        Arrays.fill(fac, 1);
        int[] inv = new int[n + 1];
        Arrays.fill(inv, 1);
        for (int i = 2; i <= n; i++)
            fac[i] = (int) ((long) i * fac[i - 1] % MODULO);
        for (int i = 2; i <= n; i++)
            inv[i] = (int) power(fac[i], MODULO - 2);
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        int[] sizes = new int[n];
        Arrays.fill(sizes, 1);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            dp[u] = (int) ((long) dp[u] * fac[sizes[u] - 1] % MODULO);
            int v = prevRoom[u];
            if (v < 0)
                continue;
            sizes[v] += sizes[u];
            if (--degree[v] == 0)
                queue.offer(v);
            dp[v] = (int) ((long) dp[v] * inv[sizes[u]] % MODULO * dp[u] % MODULO);
        }
        return dp[0];
    }

    public long power(long x, int n) {
        long pow = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 == 1)
                pow = pow * x % MODULO;
            x = x * x % MODULO;
        }
        return pow;
    }
}