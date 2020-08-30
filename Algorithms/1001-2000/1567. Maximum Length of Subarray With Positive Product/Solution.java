class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen = 0;
        List<Integer> negativeIndices = new ArrayList<Integer>();
        int start = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int curMaxLen = getMaxLen(negativeIndices, start, i - 1);
                maxLen = Math.max(maxLen, curMaxLen);
                negativeIndices.clear();
                start = i + 1;
            } else {
                if (nums[i] < 0)
                    negativeIndices.add(i);
            }
        }
        int curMaxLen = getMaxLen(negativeIndices, start, length - 1);
        maxLen = Math.max(maxLen, curMaxLen);
        return maxLen;
    }

    public int getMaxLen(List<Integer> negativeIndices, int start, int end) {
        if (start > end)
            return 0;
        int size = negativeIndices.size();
        if (size % 2 == 0)
            return end - start + 1;
        else {
            int firstIndex = negativeIndices.get(0), lastIndex = negativeIndices.get(size - 1);
            return Math.max(lastIndex - start, end - firstIndex);
        }
    }
}