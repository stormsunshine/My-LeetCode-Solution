class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() < 2)
            return S;
        if (S.length() == 2)
            return S.charAt(0) == S.charAt(1) ? "" : S;
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2)
            return "";
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int maxPossible = length / 2 + 1;
        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0 && counts[i] < maxPossible && oddIndex < length) {
                reorganizeArray[oddIndex] = (char) ('a' + i);
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = (char) ('a' + i);
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }
}