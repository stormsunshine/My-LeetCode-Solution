class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int length1 = word1.length(), length2 = word2.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            sb.append(word1.charAt(index1++));
            sb.append(word2.charAt(index2++));
        }
        while (index1 < length1)
            sb.append(word1.charAt(index1++));
        while (index2 < length2)
            sb.append(word2.charAt(index2++));
        return sb.toString();
    }
}