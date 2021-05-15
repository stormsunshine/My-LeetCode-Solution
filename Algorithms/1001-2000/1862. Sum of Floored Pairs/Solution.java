class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        final int MODULO = 1000000007;
        Arrays.sort(nums);
        Map<Integer, Integer> startIndices = new HashMap<Integer, Integer>();
        Map<Integer, Integer> endIndices = new HashMap<Integer, Integer>();
        TreeMap<Integer, Integer> counts = new TreeMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (!startIndices.containsKey(num))
                startIndices.put(num, i);
            endIndices.put(num, i);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        long sum = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int num = nums[i];
            int count = counts.get(num);
            int j = i;
            while (j < length) {
                int quotient = nums[j] / num;
                int next = num * (quotient + 1);
                Integer maxNum = counts.floorKey(next - 1);
                int endIndex = endIndices.get(maxNum);
                int range = endIndex - j + 1;
                sum = (sum + (long) count * (long) quotient * (long) range) % MODULO;
                j = endIndex + 1;
            }
        }
        return (int) sum;
    }
}