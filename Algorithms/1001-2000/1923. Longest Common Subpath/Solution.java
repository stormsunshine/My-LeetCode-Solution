class Solution {
    static final long BASE = 100001, MODULO = 100000000007L;

    public int longestCommonSubpath(int n, int[][] paths) {
        int minLength = Integer.MAX_VALUE;
        for (int[] path : paths)
            minLength = Math.min(minLength, path.length);
        long[] pow = new long[minLength + 1];
        pow[0] = 1;
        for (int i = 1; i <= minLength; i++)
            pow[i] = pow[i - 1] * BASE % MODULO;
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (check(paths, mid, pow))
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    public boolean check(int[][] paths, int mid, long[] pow) {
        int m = paths.length;
        Set<Long> set = rollingHash(paths[0], mid, pow);
        for (int i = 1; i < m; i++) {
            set.retainAll(rollingHash(paths[i], mid, pow));
            if (set.isEmpty())
                return false;
        }
        return true;
    }

    public Set<Long> rollingHash(int[] path, int mid, long[] pow) {
        Set<Long> set = new HashSet<Long>();
        long hash = 0;
        int length = path.length;
        for (int i = 0; i < mid; i++)
            hash = (hash * BASE + path[i]) % MODULO;
        set.add(hash);
        for (int prev = 0, curr = mid; curr < length; prev++, curr++) {
            hash = (hash * BASE % MODULO - path[prev] * pow[mid] % MODULO + path[curr]) % MODULO;
            if (hash < 0)
                hash += MODULO;
            set.add(hash);
        }
        return set;
    }
}