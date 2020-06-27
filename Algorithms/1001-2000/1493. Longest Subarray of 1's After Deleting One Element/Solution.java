class Solution {
    public int longestSubarray(int[] nums) {
        int length = nums.length;
        int index = 0;
        while (index < length && nums[index] == 0)
            index++;
        if (index == length)
            return 0;
        List<Integer> ones = new ArrayList<Integer>();
        List<Integer> zeros = new ArrayList<Integer>();
        int prev = 1;
        int count = 1;
        for (int i = index + 1; i < length; i++) {
            int num = nums[i];
            if (num == prev)
                count++;
            else {
                if (prev == 1)
                    ones.add(count);
                else
                    zeros.add(count);
                prev = num;
                count = 1;
            }
        }
        if (prev == 1)
            ones.add(count);
        else
            zeros.add(count);
        if (index == 0 && zeros.size() == 0)
            return ones.get(0) - 1;
        int maxLength = ones.get(0);
        int size = ones.size();
        for (int i = 1; i < size; i++) {
            int zero = zeros.get(i - 1);
            int prevOne = ones.get(i - 1);
            int one = ones.get(i);
            maxLength = Math.max(maxLength, one);
            if (zero == 1)
                maxLength = Math.max(maxLength, prevOne + one);
        }
        return maxLength;
    }
}