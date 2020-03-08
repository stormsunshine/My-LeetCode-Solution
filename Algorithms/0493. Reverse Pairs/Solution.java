class Solution {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    public int mergeSortAndCount(int[] nums, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int midIndex = (endIndex - startIndex) / 2 + startIndex;
            int count = mergeSortAndCount(nums, startIndex, midIndex) + mergeSortAndCount(nums, midIndex + 1, endIndex);
            int index1 = startIndex, index2 = midIndex + 1;
            while (index1 <= midIndex && index2 <= endIndex) {
                if ((long) nums[index1] > 2 * (long) nums[index2]) {
                    count += midIndex - index1 + 1;
                    index2++;
                } else
                    index1++;
            }
            merge(nums, startIndex, midIndex, endIndex);
            return count;
        } else
            return 0;
    }

    public void merge(int[] nums, int startIndex, int midIndex, int endIndex) {
        int length = endIndex - startIndex + 1;
        int[] newArray = new int[length];
        int index1 = startIndex, index2 = midIndex + 1;
        int index = 0;
        while (index1 <= midIndex && index2 <= endIndex) {
            if (nums[index1] <= nums[index2])
                newArray[index++] = nums[index1++];
            else
                newArray[index++] = nums[index2++];
        }
        while (index1 <= midIndex)
            newArray[index++] = nums[index1++];
        while (index2 <= endIndex)
            newArray[index++] = nums[index2++];
        for (int i = 0; i < length; i++)
            nums[startIndex + i] = newArray[i];
    }
}