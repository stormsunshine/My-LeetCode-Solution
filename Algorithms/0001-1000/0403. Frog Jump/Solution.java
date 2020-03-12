class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer> stonesSet = new HashSet<Integer>();
        for (int stone : stones)
            stonesSet.add(stone);
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int length = stones.length;
        Set<Integer> set0 = new HashSet<Integer>();
        set0.add(0);
        map.put(0, set0);
        for (int i = 0; i < length; i++) {
            int curStone = stones[i];
            Set<Integer> set = map.getOrDefault(curStone, new HashSet<Integer>());
            for (int k : set) {
                int begin = Math.max(1, k - 1), end = k + 1;
                for (int step = begin; step <= end; step++) {
                    int nextPosition = curStone + step;
                    if (stonesSet.contains(nextPosition)) {
                        Set<Integer> nextSet = map.getOrDefault(nextPosition, new HashSet<Integer>());
                        nextSet.add(step);
                        map.put(nextPosition, nextSet);
                    }
                }
            }
        }
        int lastStone = stones[length - 1];
        return map.containsKey(lastStone);
    }
}