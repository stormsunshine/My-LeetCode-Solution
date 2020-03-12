class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        int majority1 = nums[0], majority2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == majority1)
                count1++;
            else if (num == majority2)
                count2++;
            else if (count1 == 0) {
                majority1 = num;
                count1++;
            } else if (count2 == 0) {
                majority2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == majority1)
                count1++;
            else if (num == majority2)
                count2++;
        }
        int leastMajorityCount = nums.length / 3 + 1;
        List<Integer> majorityElements = new ArrayList<Integer>();
        if (count1 >= leastMajorityCount)
            majorityElements.add(majority1);
        if (count2 >= leastMajorityCount)
            majorityElements.add(majority2);
        return majorityElements;
    }
}