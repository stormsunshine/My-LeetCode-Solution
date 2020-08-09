class Solution {
    Map<Long, Integer> map = new HashMap<Long, Integer>();
    static final int INFINITY = 100000000;

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int length = cuts.length;
        map.put((long) cuts[0], 0);
        for (int i = 1; i < length; i++) {
            long key = (long) cuts[i - 1] * (long) (n + 1) + cuts[i];
            map.put(key, 0);
        }
        map.put((long) (cuts[length - 1]) * (long) (n + 1) + n, 0);
        return calculate(n, 0, n, cuts);
    }

    public int calculate(int n, int start, int end, int[] cuts) {
        long key = (long) start * (long) (n + 1) + end;
        if (map.containsKey(key))
            return map.get(key);
        int minCost = INFINITY;
        int length = cuts.length;
        for (int i = 0; i < length; i++) {
            int cut = cuts[i];
            if (cut > start && cut < end) {
                int cost = (end - start) + calculate(n, start, cut, cuts) + calculate(n, cut, end, cuts);
                minCost = Math.min(minCost, cost);
            } else if (cut >= end)
                break;
        }
        map.put(key, minCost);
        return minCost;
    }
}