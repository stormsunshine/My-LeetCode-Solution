class Solution {
    public String nearestPalindromic(String n) {
        long[] nearestPalindromes = getNearestPalindromes(n);
        long num = Long.parseLong(n);
        long nearest = nearestPalindromes[0];
        long minDifference = Math.abs(num - nearest);
        int length = nearestPalindromes.length;
        for (int i = 1; i < length; i++) {
            long curPalindrome = nearestPalindromes[i];
            long difference = Math.abs(num - curPalindrome);
            if (difference > 0 && difference < minDifference) {
                nearest = curPalindrome;
                minDifference = difference;
            }
        }
        return String.valueOf(nearest);
    }

    public long[] getNearestPalindromes(String n) {
        int length = n.length();
        long min = (long) Math.pow(10, length - 1) - 1;
        long max = (long) Math.pow(10, length) + 1;
        int halfLength = (length + 1) / 2;
        String highHalfStr = n.substring(0, halfLength);
        long highHalf = Long.parseLong(highHalfStr);
        long[] nearestPalindromes = new long[3];
        nearestPalindromes[1] = generatePalindrome(highHalf, length);
        long prevHighHalf = highHalf - 1;
        int prevLength = prevHighHalf == 0 ? 0 : String.valueOf(prevHighHalf).length();
        if (prevLength == halfLength)
            nearestPalindromes[0] = generatePalindrome(prevHighHalf, length);
        else
            nearestPalindromes[0] = min;
        long nextHighHalf = highHalf + 1;
        int nextLength = String.valueOf(nextHighHalf).length();
        if (nextLength == halfLength)
            nearestPalindromes[2] = generatePalindrome(nextHighHalf, length);
        else
            nearestPalindromes[2] = max;
        return nearestPalindromes;
    }

    public long generatePalindrome(long highHalf, int length) {
        String highHalfStr = String.valueOf(highHalf);
        StringBuffer sb = new StringBuffer(highHalfStr);
        for (int i = length / 2 - 1; i >= 0; i--)
            sb.append(highHalfStr.charAt(i));
        return Long.parseLong(sb.toString());
    }
}