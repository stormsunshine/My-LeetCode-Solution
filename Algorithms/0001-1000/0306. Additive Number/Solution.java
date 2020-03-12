import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0)
            return false;
        int length = num.length();
        int firstMax = length / 2, secondMax = length * 2 / 3;
        for (int i = 1; i <= firstMax; i++) {
            if (i > 1 && num.charAt(0) == '0')
                break;
            for (int j = i + 1; j <= secondMax; j++) {
                String firstNumStr = num.substring(0, i);
                String secondNumStr = num.substring(i, j);
                if (secondNumStr.length() > 1 && secondNumStr.charAt(0) == '0')
                    break;
                StringBuffer sb = new StringBuffer(firstNumStr + secondNumStr);
                while (sb.length() < length) {
                    BigInteger firstNum = new BigInteger(firstNumStr);
                    BigInteger secondNum = new BigInteger(secondNumStr);
                    BigInteger sum = firstNum.add(secondNum);
                    String sumStr = sum.toString();
                    sb.append(sumStr);
                    firstNumStr = secondNumStr;
                    secondNumStr = sumStr;
                }
                if (sb.toString().equals(num))
                    return true;
            }
        }
        return false;
    }
}