class Solution {
    public int repeatedStringMatch(String A, String B) {
        int lengthA = A.length(), lengthB = B.length();
        StringBuffer sb = new StringBuffer();
        int maxLength = lengthA * 2 + lengthB;
        int repeatTimes = 0;
        while (sb.length() <= maxLength) {
            sb.append(A);
            repeatTimes++;
            if (sb.toString().indexOf(B) >= 0)
                return repeatTimes;
        }
        return -1;
    }
}