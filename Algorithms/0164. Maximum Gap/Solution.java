class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max - min == 0)
            return 0;
        int length = nums.length;
        int bucketsCount = length - 1;
        int interval = (int) Math.ceil(1.0 * (max - min) / bucketsCount);
        int[] bucketsMin = new int[bucketsCount];
        int[] bucketsMax = new int[bucketsCount];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, -1);
        for (int num : nums) {
            if (num == min || num == max)
                continue;
            int index = (num - min) / interval;
            bucketsMin[index] = Math.min(bucketsMin[index], num);
            bucketsMax[index] = Math.max(bucketsMax[index], num);
        }
        int maxGap = 0;
        int prevMax = min;
        for (int i = 0; i < bucketsCount; i++) {
            if (bucketsMax[i] == -1)
                continue;
            maxGap = Math.max(maxGap, bucketsMin[i] - prevMax);
            prevMax = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, max - prevMax);
        return maxGap;
    }
}