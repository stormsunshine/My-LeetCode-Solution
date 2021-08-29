class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String num1, String num2) {
                if (num1.length() != num2.length())
                    return num1.length() - num2.length();
                else
                    return num1.compareTo(num2);
            }
        });
        return nums[nums.length - k];
    }
}