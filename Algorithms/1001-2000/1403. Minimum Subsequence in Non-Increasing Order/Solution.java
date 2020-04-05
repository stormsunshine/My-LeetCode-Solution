class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int halfSum = sum / 2;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        int subsum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            list.add(num);
            subsum += num;
            if (subsum > halfSum)
                break;
        }
        return list;
    }
}