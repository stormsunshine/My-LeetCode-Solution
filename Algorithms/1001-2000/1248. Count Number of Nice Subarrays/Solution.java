class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> oddIndices = new ArrayList<Integer>();
        oddIndices.add(-1);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 != 0)
                oddIndices.add(i);
        }
        oddIndices.add(length);
        int count = 0;
        int oddIndicesSize = oddIndices.size() - 2;
        int start = 1, end = oddIndicesSize - k + 1;
        for (int low = start; low <= end; low++) {
            int high = low + k - 1;
            int indexLow = oddIndices.get(low), indexHigh = oddIndices.get(high);
            int indexPrev = oddIndices.get(low - 1), indexNext = oddIndices.get(high + 1);
            count += (indexLow - indexPrev) * (indexNext - indexHigh);
        }
        return count;
    }
}