class Solution {
    public boolean checkRecord(String s) {
        int absents = 0, continuousLates = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                continuousLates++;
                if (continuousLates > 2)
                    return false;
            } else {
                if (c == 'A') {
                    absents++;
                    if (absents > 1)
                        return false;
                }
                continuousLates = 0;
            }
        }
        return true;
    }
}