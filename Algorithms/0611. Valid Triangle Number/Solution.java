class Solution {
    public int triangleNumber(int[] nums) {
        int length = nums.length;
        if (length < 3)
            return 0;
        int count = 0;
        Arrays.sort(nums);
        int startIndex = 0;
        while (startIndex < length && nums[startIndex] == 0)
            startIndex++;
        int end1 = length - 2;
        int end2 = length - 1;
        for (int i = startIndex; i < end1; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < end2; j++) {
                int num2 = nums[j];
                for (int k = j + 1; k < length; k++) {
                    int num3 = nums[k];
                    if (num1 + num2 > num3)
                        count++;
                    else
                        break;
                }
            }
        }
        return count;
    }
}