class Solution {
    public int[] avoidFlood(int[] rains) {
        if (rains == null || rains.length == 0)
            return rains;
        int length = rains.length;
        int[] ans = new int[length];
        Queue<Integer> lakeQueue = new LinkedList<Integer>();
        TreeSet<Integer> drySet = new TreeSet<Integer>();
        for (int i = 0; i < length; i++) {
            if (rains[i] > 0) {
                ans[i] = -1;
                lakeQueue.offer(i);
            } else 
                drySet.add(i);
        }
        while (!drySet.isEmpty() && !lakeQueue.isEmpty() && drySet.first() < lakeQueue.peek()) {
            int dryIndex = drySet.first();
            ans[dryIndex] = 1;
            drySet.remove(dryIndex);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (!lakeQueue.isEmpty()) {
            int index = lakeQueue.poll();
            int lake = rains[index];
            if (!map.containsKey(lake))
                map.put(lake, index);
            else {
                int prevIndex = map.get(lake);
                Integer dryIndex = drySet.ceiling(prevIndex);
                if (dryIndex == null || dryIndex > index)
                    return new int[0];
                else {
                    ans[dryIndex] = lake;
                    drySet.remove(dryIndex);
                    map.put(lake, index);
                }
            }
        }
        for (int dryIndex : drySet)
            ans[dryIndex] = 1;
        return ans;
    }
}