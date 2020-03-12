class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersectionList = new ArrayList<Integer>();
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                intersectionList.add(num1);
                index1++;
                index2++;
            } else if (num1 < num2)
                index1++;
            else
                index2++;
        }
        int length = intersectionList.size();
        int[] intersection = new int[length];
        for (int i = 0; i < length; i++)
            intersection[i] = intersectionList.get(i);
        return intersection;
    }
}