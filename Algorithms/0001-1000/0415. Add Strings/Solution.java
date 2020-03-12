class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0"))
            return "0";
        int length1 = num1.length(), length2 = num2.length();
        while (num1.length() < length2)
            num1 = "0" + num1;
        while (num2.length() < length1)
            num2 = "0" + num2;
        int totalLength = Math.max(length1, length2) + 1;
        int[] sumArray = new int[totalLength];
        for (int i = totalLength - 1; i > 0; i--) {
            int digit1 = num1.charAt(i - 1) - '0';
            int digit2 = num2.charAt(i - 1) - '0';
            sumArray[i] += digit1 + digit2;
            if (sumArray[i] >= 10) {
                sumArray[i - 1] += sumArray[i] / 10;
                sumArray[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (sumArray[0] != 0)
            sb.append(sumArray[0]);
        for (int i = 1; i < totalLength; i++)
            sb.append(sumArray[i]);
        String sum = sb.toString();
        return sum;
    }
}