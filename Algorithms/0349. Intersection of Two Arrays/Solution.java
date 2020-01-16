class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int num : nums1)
            set1.add(num);
        List<Integer> intersectionList = new ArrayList<Integer>();
        for (int num : nums2) {
            if (set1.contains(num) && !intersectionList.contains(num))
                intersectionList.add(num);
        }
        int length = intersectionList.size();
        int[] intersection = new int[length];
        for (int i = 0; i < length; i++)
            intersection[i] = intersectionList.get(i);
        return intersection;
    }
}