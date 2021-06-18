class Solution {
    public int maxDepthBST(int[] order) {
        TreeMap<Integer, Integer> depthMap = new TreeMap<Integer, Integer>();
        depthMap.put(order[0], 1);
        int maxDepth = 1;
        int length = order.length;
        for (int i = 1; i < length; i++) {
            int curr = order[i];
            Integer prev = depthMap.floorKey(curr - 1);
            Integer next = depthMap.ceilingKey(curr + 1);
            int currDepth = 0;
            if (prev != null && next != null)
                currDepth = Math.max(depthMap.get(prev), depthMap.get(next)) + 1;
            else if (prev != null)
                currDepth = depthMap.get(prev) + 1;
            else
                currDepth = depthMap.get(next) + 1;
            depthMap.put(curr, currDepth);
            maxDepth = Math.max(maxDepth, currDepth);
        }
        return maxDepth;
    }
}