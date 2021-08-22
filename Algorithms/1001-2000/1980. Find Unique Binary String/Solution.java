class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        int maxNum = (1 << length) - 1;
        Set<Integer> set = new HashSet<Integer>();
        for (String num : nums)
            set.add(Integer.parseInt(num, 2));
        int different = 0;
        for (int i = 0; i <= maxNum; i++) {
            if (!set.contains(i)) {
                different = i;
                break;
            }
        }
        String differentStr = toBinaryString(different, length);
        return differentStr;
    }

    public String toBinaryString(int num, int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int remainder = num % 2;
            sb.append(remainder);
            num /= 2;
        }
        sb.reverse();
        return sb.toString();
    }
}