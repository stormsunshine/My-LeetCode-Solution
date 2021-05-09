class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = length1 - 1, index2 = length2 - 1;
        while (index1 >= 0 && index2 >= 0) {
            while (index1 >= 0 && nums1[index1] <= nums2[index2]) {
                maxDistance = Math.max(maxDistance, index2 - index1);
                index1--;
            }
            index2--;
        }
        return maxDistance;
    }
}