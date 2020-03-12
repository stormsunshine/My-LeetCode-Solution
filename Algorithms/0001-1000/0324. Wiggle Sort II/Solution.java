public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] temp = new int[length];
        int mid = (length + 1) / 2;
        for (int i = 0; i < mid; i++)
            temp[2 * (mid - i - 1)] = nums[i];
        for (int i = mid; i < length; i++)
            temp[2 * (length - i - 1) + 1] = nums[i];
        for (int i = 0; i < length; i++)
            nums[i] = temp[i];
    }
}