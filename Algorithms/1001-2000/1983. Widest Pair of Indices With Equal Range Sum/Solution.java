class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] differences = new int[length];
        for (int i = 0; i < length; i++)
            differences[i] = nums1[i] - nums2[i];
        int[] prefixSums = new int[length];
        prefixSums[0] = differences[0];
        for (int i = 1; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] + differences[i];
        int maxDistance = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < length; i++) {
            int sum = prefixSums[i];
            if (map.containsKey(sum))
                maxDistance = Math.max(maxDistance, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return maxDistance;
    }
}