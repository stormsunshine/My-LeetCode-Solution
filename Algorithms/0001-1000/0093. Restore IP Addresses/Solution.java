class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        int length = s.length();
        if (length > 12)
            return list;
        int max0 = length - 3, max1 = length - 2, max2 = length - 1;
        int maxFirst = Math.min(3, max0);
        for (int i = 1; i <= maxFirst; i++) {
            String num0Str = s.substring(0, i);
            if (num0Str.length() > 1 && num0Str.charAt(0) == '0')
                break;
            int num0 = Integer.parseInt(num0Str);
            if (num0 > 255)
                break;
            int maxSecond = Math.min(i + 3, max1);
            for (int j = i + 1; j <= maxSecond; j++) {
                String num1Str = s.substring(i, j);
                if (num1Str.length() > 1 && num1Str.charAt(0) == '0')
                    break;
                int num1 = Integer.parseInt(num1Str);
                if (num1 > 255)
                    break;
                int maxThird = Math.min(j + 3, max2);
                for (int k = j + 1; k <= maxThird; k++) {
                    String num2Str = s.substring(j, k);
                    String num3Str = s.substring(k);
                    if (num2Str.length() > 1 && num2Str.charAt(0) == '0' || num3Str.length() > 1 && num3Str.charAt(0) == '0')
                        continue;
                    int num2 = Integer.parseInt(num2Str);
                    int num3 = Integer.parseInt(num3Str);
                    if (num2 > 255)
                        break;
                    if (num2 <= 255 && num3 <= 255) {
                        String ip = generateIP(new int[]{num0, num1, num2, num3});
                        list.add(ip);
                    }
                }
            }
        }
        return list;
    }

    public String generateIP(int[] nums) {
        StringBuffer sb = new StringBuffer();
        sb.append(nums[0]);
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            sb.append('.');
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}