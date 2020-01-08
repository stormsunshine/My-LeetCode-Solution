class Solution {
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        int length = nums.length;
        if (length == 1)
            return String.valueOf(nums[0]);
        if (length == 2)
            return nums[0] + "/" + nums[1];
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(nums[0]));
        sb.append("/");
        sb.append("(");
        for (int i = 1; i < length; i++) {
            sb.append(String.valueOf(nums[i]));
            if (i < length - 1)
                sb.append("/");
        }
        sb.append(")");
        return sb.toString();
    }
}