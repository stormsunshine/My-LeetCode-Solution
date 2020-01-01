class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null)
            return false;
        int sLength = s.length(), tLength = t.length();
        if (sLength == 0)
            return true;
        int sIndex = 0;
        for (int i = 0; i < tLength; i++) {
            char sChar = s.charAt(sIndex);
            char tChar = t.charAt(i);
            if (sChar == tChar)
                sIndex++;
            if (sIndex == sLength)
                return true;
        }
        return false;
    }
}