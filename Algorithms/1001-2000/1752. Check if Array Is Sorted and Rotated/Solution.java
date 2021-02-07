class Solution {
    public boolean check(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums)
            min = Math.min(min, num);
        List<Integer> minIndices = new ArrayList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == min)
                minIndices.add(i);
        }
        int size = minIndices.size();
        for (int i = 0; i < size; i++) {
            if (i > 0 && minIndices.get(i) - minIndices.get(i - 1) == 1)
                continue;
            int minIndex = minIndices.get(i);
            int[] newNums = new int[length];
            for (int j = 0; j < length; j++)
                newNums[j] = nums[(minIndex + j) % length];
            boolean flag = true;
            for (int j = 1; j < length; j++) {
                if (newNums[j] < newNums[j - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
        }
        return false;
    }
}