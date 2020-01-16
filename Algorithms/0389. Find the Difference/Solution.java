class Solution {
    public char findTheDifference(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (char c : sArray)
            sCount[c - 'a']++;
        for (char c : tArray)
            tCount[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (tCount[i] > sCount[i])
                return (char) (i + 'a');
        }
        return '0';
    }
}