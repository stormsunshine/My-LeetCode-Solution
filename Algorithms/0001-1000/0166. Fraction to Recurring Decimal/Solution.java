class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (denominatorLong < 0) {
            numeratorLong = -numeratorLong;
            denominatorLong = -denominatorLong;
        }
        String sign = numeratorLong < 0 ? "-" : "";
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        long remainder = Math.abs(numeratorLong % denominatorLong);
        if (remainder == 0)
            return sign + String.valueOf(integerPart);
        else {
            StringBuffer decimalPartSB = new StringBuffer();
            Set<Long> remainderSet = new HashSet<Long>();
            Map<Long, Integer> remainderPositionMap = new HashMap<Long, Integer>();
            int position = 0;
            while (remainder != 0 && remainderSet.add(remainder)) {
                remainderPositionMap.put(remainder, position);
                remainder *= 10;
                decimalPartSB.append(remainder / denominatorLong);
                remainder %= denominatorLong;
                position++;
            }
            if (remainder != 0) {
                int startPosition = remainderPositionMap.getOrDefault(remainder, 0);
                decimalPartSB.insert(startPosition, "(");
                decimalPartSB.append(")");
            }
            String decimalStr = sign + integerPart + "." + decimalPartSB.toString();
            return decimalStr;
        }
    }
}