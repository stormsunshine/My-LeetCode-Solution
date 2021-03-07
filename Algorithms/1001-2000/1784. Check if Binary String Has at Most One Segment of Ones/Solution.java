class Solution {
    public boolean checkOnesSegment(String s) {
        int onesSegments = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                if (i == 0 || s.charAt(i - 1) == '0')
                    onesSegments++;
            }
        }
        return onesSegments <= 1;
    }
}