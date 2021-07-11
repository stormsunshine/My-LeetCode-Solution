class Solution {
    public boolean sumGame(String num) {
        int sum1 = 0, sum2 = 0;
        int remain1 = 0, remain2 = 0;
        int length = num.length();
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            char c = num.charAt(i);
            if (c == '?')
                remain1++;
            else
                sum1 += c - '0';
        }
        for (int i = halfLength; i < length; i++) {
            char c = num.charAt(i);
            if (c == '?')
                remain2++;
            else
                sum2 += c - '0';
        }
        if ((remain1 + remain2) % 2 != 0)
            return true;
        int difference = sum1 - sum2;
        if (difference == 0)
            return remain1 != remain2;
        if (difference > 0 && remain1 >= remain2)
            return true;
        if (difference < 0 && remain1 <= remain2)
            return true;
        if (difference > 0) {
            if (difference < 9)
                return true;
            int maxDifference = (remain2 - remain1) / 2 * 9;
            return maxDifference != difference;
        } else {
            if (difference > -9)
                return true;
            int maxDifference = (remain1 - remain2) / 2 * 9;
            return maxDifference != -difference;
        }
    }
}