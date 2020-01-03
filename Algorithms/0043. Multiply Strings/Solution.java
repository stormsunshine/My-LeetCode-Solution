class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int length1 = num1.length(), length2 = num2.length();
        int totalLength = length1 + length2;
        int[] multiplyArray = new int[totalLength];
        for (int j = 0; j < length2; j++) {
            int digit2 = num2.charAt(length2 - 1 - j) - '0';
            for (int i = 0; i < length1; i++) {
                int digit1 = num1.charAt(length1 - 1 - i) - '0';
                multiplyArray[totalLength - 1 - i - j] += digit1 * digit2;
                if (multiplyArray[totalLength - 1 - i - j] >= 10) {
                    multiplyArray[totalLength - 2 - i - j] += multiplyArray[totalLength - 1 - i - j] / 10;
                    multiplyArray[totalLength - 1 - i - j] %= 10;
                }
            }
        }
        boolean flag = false;
        StringBuffer multiplySB = new StringBuffer();
        for (int i = 0; i < totalLength; i++) {
            int digit = multiplyArray[i];
            if (!flag && digit == 0)
                continue;
            multiplySB.append(digit);
            flag = true;
        }
        String multiplyStr = multiplySB.toString();
        return multiplyStr;
    }
}