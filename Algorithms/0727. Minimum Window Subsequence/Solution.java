class Solution {
    public String minWindow(String S, String T) {
        if (S.equals(T))
            return S;
        int sLength = S.length(), tLength = T.length();
        int start = 0, end = sLength - 1;
        int sIndex = 0, tIndex = 0;
        while (sIndex < sLength) {
            if (S.charAt(sIndex) == T.charAt(tIndex))
                tIndex++;
            if (tIndex == tLength) {
                int rightIndex = sIndex;
                tIndex--;
                while (tIndex >= 0) {
                    if (S.charAt(sIndex) == T.charAt(tIndex))
                        tIndex--;
                    sIndex--;
                }
                sIndex++;
                if (rightIndex - sIndex < end - start) {
                    start = sIndex;
                    end = rightIndex;
                }
                tIndex = 0;
            }
            sIndex++;
        }
        int windowSize = end - start + 1;
        if (windowSize == sLength)
            return "";
        else
            return S.substring(start, start + windowSize);
    }
}