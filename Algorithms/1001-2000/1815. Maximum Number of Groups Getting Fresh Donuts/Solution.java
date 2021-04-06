class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        long state = 0;
        int mod0 = 0;
        for (int group : groups) {
            group %= batchSize;
            if (group == 0)
                mod0++;
            else
                state += 1L << (group * 5);
        }
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        return mod0 + dp(0, state, batchSize, map);
    }

    public int dp(int curr, long state, int batchSize, Map<Long, Integer> map) {
        if (!map.containsKey(state)) {
            if (state == 0)
                map.put(state, 0);
            else {
                int val = 0;
                for (int i = 1; i < batchSize; i++) {
                    if ((state >>> (i * 5)) % 32 != 0) {
                        int nextVal = dp((curr + i) % batchSize, state - (1L << (i * 5)), batchSize, map);
                        val = Math.max(val, curr != 0 ? nextVal : nextVal + 1);
                    }
                }
                map.put(state, val);
            }
        }
        return map.get(state);
    }
}