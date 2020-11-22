class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        int length1 = word1.length, length2 = word2.length;
        for (int i = 0; i < length1; i++)
            sb1.append(word1[i]);
        for (int i = 0; i < length2; i++)
            sb2.append(word2[i]);
        String str1 = sb1.toString();
        String str2 = sb2.toString();
        return str1.equals(str2);
    }
}