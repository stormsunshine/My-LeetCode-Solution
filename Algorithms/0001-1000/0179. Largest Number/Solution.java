class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        if (nums.length == 1)
            return String.valueOf(nums[0]);
        int length = nums.length;
        String[] array = new String[length];
        for (int i = 0; i < length; i++)
            array[i] = String.valueOf(nums[i]);
        Arrays.sort(array, new Comparator<String>() {
            public int compare(String num1, String num2) {
                return num2.concat(num1).compareTo(num1.concat(num2));
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++)
            sb.append(array[i]);
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}