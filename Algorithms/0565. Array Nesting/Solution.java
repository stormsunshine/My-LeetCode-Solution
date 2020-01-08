class Solution {
    public int arrayNesting(int[] nums) {
        int length = nums.length;
        boolean[] visited = new boolean[length];
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            if (visited[i])
                continue;
            int curLength = 0;
            int index = i;
            while (!visited[index]) {
                int num = nums[index];
                visited[index] = true;
                index = num;
                curLength++;
            }
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }
}