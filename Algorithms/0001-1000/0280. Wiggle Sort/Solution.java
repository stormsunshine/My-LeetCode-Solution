class Solution {
    public void wiggleSort(int[] nums) {
        bubbleSort(nums);
        int length = nums.length;
        for (int i = 1; i < length - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }

    public void bubbleSort(int[] nums) {
        int length = nums.length;
        boolean needNextPass = true;
        for (int i = 1; i < length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}