class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        if (length1 > length2) {
            int[] tempArray = nums1;
            nums1 = nums2;
            nums2 = tempArray;
            int temp = length1;
            length1 = length2;
            length2 = temp;
        }
        int low = 0, high = length1, halfLength = (length1 + length2 + 1) / 2;
        while (low <= high) {
            int index1 = (high - low) / 2 + low;
            int index2 = halfLength - index1;
            if (index1 < high && nums1[index1] < nums2[index2 - 1])
                low = index1 + 1;
            else if (index1 > low && nums1[index1 - 1] > nums2[index2])
                high = index1 - 1;
            else {
                int maxLeft = index1 == 0 ? nums2[index2 - 1] : index2 == 0 ? nums1[index1 - 1] : Math.max(nums1[index1 - 1], nums2[index2 - 1]);
                if ((length1 + length2) % 2 == 1)
                    return maxLeft;
                int minRight = index1 == length1 ? nums2[index2] : index2 == length2 ? nums1[index1] : Math.min(nums1[index1], nums2[index2]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}