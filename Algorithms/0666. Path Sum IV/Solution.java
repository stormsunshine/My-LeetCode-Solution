class Solution {
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> depthPositionValueMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int depthPosition = num / 10, value = num % 10;
            depthPositionValueMap.put(depthPosition, value);
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        int num0 = nums[0];
        queue.offer(new int[]{num0 / 10, num0 % 10});
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] depthPositionValue = queue.poll();
            int depthPosition = depthPositionValue[0], value = depthPositionValue[1];
            int depth = depthPosition / 10, position = depthPosition % 10;
            int leftDepthPosition = (depth + 1) * 10 + position * 2 - 1, rightDepthPosition = (depth + 1) * 10 + position * 2;
            int left = depthPositionValueMap.getOrDefault(leftDepthPosition, -1), right = depthPositionValueMap.getOrDefault(rightDepthPosition, -1);
            if (left < 0 && right < 0)
                sum += value;
            else {
                if (left >= 0) {
                    int leftValue = left % 10;
                    queue.offer(new int[]{leftDepthPosition, value + leftValue});
                } if (right >= 0) {
                    int rightValue = right % 10;
                    queue.offer(new int[]{rightDepthPosition, value + rightValue});
                }
            }
        }
        return sum;
    }
}