class Solution {
    public int maximumBeauty(int[] flowers) {
        int length = flowers.length;
        int[] prefixSums = new int[length + 1];
        for (int i = 0; i < length; i++)
            prefixSums[i + 1] = prefixSums[i] + Math.max(0, flowers[i]);
        int maxBeauty = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            int flower = flowers[i];
            if (map.containsKey(flower)) {
                int firstIndex = map.get(flower);
                int beauty = flower * 2 + prefixSums[i] - prefixSums[firstIndex + 1];
                maxBeauty = Math.max(maxBeauty, beauty);
            } else
                map.put(flower, i);
        }
        return maxBeauty;
    }
}