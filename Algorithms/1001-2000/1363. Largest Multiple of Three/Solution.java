class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        List<Integer> remainderZeros = new ArrayList<Integer>();
        List<Integer> remainderOnes = new ArrayList<Integer>();
        List<Integer> remainderTwos = new ArrayList<Integer>();
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            int digit = digits[i];
            sum += digit;
            if (digit % 3 == 0)
                remainderZeros.add(digit);
            else if (digit % 3 == 1)
                remainderOnes.add(digit);
            else
                remainderTwos.add(digit);
        }
        int remainder = sum % 3;
        if (remainder == 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++)
                sb.append(digits[i]);
            sb.reverse();
            if (sb.charAt(0) == '0')
                return "0";
            else
                return sb.toString();
        } else if (remainder == 1) {
            if (remainderOnes.size() >= 1) {
                int minOne = remainderOnes.get(0);
                boolean flag = false;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < length; i++) {
                    int digit = digits[i];
                    if (!flag) {
                        if (digit == minOne)
                            flag = true;
                        else
                            sb.append(digit);
                    } else
                        sb.append(digit);
                }
                sb.reverse();
                if (sb.length() == 0)
                    return "";
                else if (sb.charAt(0) == '0')
                    return "0";
                else
                    return sb.toString();
            } else if (remainderTwos.size() >= 2) {
                int minTwo1 = remainderTwos.get(0), minTwo2 = remainderTwos.get(1);
                int deleteCount = 0;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < length; i++) {
                    int digit = digits[i];
                    if (deleteCount == 0) {
                        if (digit == minTwo1)
                            deleteCount++;
                        else
                            sb.append(digit);
                    } else if (deleteCount == 1) {
                        if (digit == minTwo2)
                            deleteCount++;
                        else
                            sb.append(digit);
                    } else
                        sb.append(digit);
                }
                sb.reverse();
                if (sb.length() == 0)
                    return "";
                else if (sb.charAt(0) == '0')
                    return "0";
                else
                    return sb.toString();
            } else
                return "";
        } else {
            if (remainderTwos.size() >= 1) {
                int minTwo = remainderTwos.get(0);
                boolean flag = false;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < length; i++) {
                    int digit = digits[i];
                    if (!flag) {
                        if (digit == minTwo)
                            flag = true;
                        else
                            sb.append(digit);
                    } else
                        sb.append(digit);
                }
                sb.reverse();
                if (sb.length() == 0)
                    return "";
                else if (sb.charAt(0) == '0')
                    return "0";
                else
                    return sb.toString();
            } else if (remainderOnes.size() >= 2) {
                int minOne1 = remainderOnes.get(0), minOne2 = remainderOnes.get(1);
                int deleteCount = 0;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < length; i++) {
                    int digit = digits[i];
                    if (deleteCount == 0) {
                        if (digit == minOne1)
                            deleteCount++;
                        else
                            sb.append(digit);
                    } else if (deleteCount == 1) {
                        if (digit == minOne2)
                            deleteCount++;
                        else
                            sb.append(digit);
                    } else
                        sb.append(digit);
                }
                sb.reverse();
                if (sb.length() == 0)
                    return "";
                else if (sb.charAt(0) == '0')
                    return "0";
                else
                    return sb.toString();
            } else
                return "";
        }
    }
}