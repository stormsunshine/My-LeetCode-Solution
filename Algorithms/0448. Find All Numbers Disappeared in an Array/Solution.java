class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1])
                    break;
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        List<Integer> disappearedNumbers = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1)
                disappearedNumbers.add(i + 1);
        }
        return disappearedNumbers;
    }
}