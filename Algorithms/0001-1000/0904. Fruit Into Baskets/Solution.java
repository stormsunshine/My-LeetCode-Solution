class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> typeCountMap = new HashMap<Integer, Integer>();
        int maxTotalCount = 0;
        int start = 0;
        int length = tree.length;
        for (int i = 0; i < length; i++) {
            int type = tree[i];
            int count = typeCountMap.getOrDefault(type, 0);
            count++;
            typeCountMap.put(type, count);
            while (typeCountMap.keySet().size() > 2) {
                int prevType = tree[start];
                int prevCount = typeCountMap.getOrDefault(prevType, 0);
                if (prevCount > 0)
                    prevCount--;
                if (prevCount == 0)
                    typeCountMap.remove(prevType);
                else
                    typeCountMap.put(prevType, prevCount);
                start++;
            }
            maxTotalCount = Math.max(maxTotalCount, i - start + 1);
        }
        return maxTotalCount;
    }
}