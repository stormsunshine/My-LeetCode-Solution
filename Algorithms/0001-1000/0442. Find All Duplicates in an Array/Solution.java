class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();
        for (int num : nums) {
            num = Math.abs(num);
            if (nums[num - 1] < 0)
                duplicates.add(num);
            else
                nums[num - 1] *= -1;
        }
        return duplicates;
    }
}