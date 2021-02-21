class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int length = nums.length;
        int groupsCount = groups.length;
        int curIndex = 0;
        for (int i = 0; i < groupsCount; i++) {
            int[] group = groups[i];
            int groupStart = findGroupStart(group, nums, curIndex);
            if (groupStart < 0)
                return false;
            curIndex = groupStart + group.length;
            if (curIndex >= length && i < groupsCount - 1)
                return false;
        }
        return true;
    }

    public int findGroupStart(int[] group, int[] nums, int start) {
        int length = nums.length;
        int groupLength = group.length;
        int maxStart = length - groupLength;
        for (int i = start; i <= maxStart; i++) {
            boolean flag = true;
            for (int j = 0; j < groupLength; j++) {
                if (nums[i + j] != group[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return i;
        }
        return -1;
    }
}