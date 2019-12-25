class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String allLongestCommonPrefix = strs[0];
        int length = strs.length;
        for (int i = 1; i < length; i++)
            allLongestCommonPrefix = longestCommonPrefix(allLongestCommonPrefix, strs[i]);
        return allLongestCommonPrefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        String longestCommonPrefix = "";
        int length = Math.min(str1.length(), str2.length());
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i))
                longestCommonPrefix += str1.charAt(i);
            else
                break;
        }
        return longestCommonPrefix;
    }
}