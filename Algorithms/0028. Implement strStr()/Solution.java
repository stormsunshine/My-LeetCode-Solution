class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int haystackLength = haystack.length(), needleLength = needle.length();
        int[] prefix = prefix(needle);
        int index = -1;
        for (int i = 0; i < haystackLength; i++) {
            while (index >= 0 && needle.charAt(index + 1) != haystack.charAt(i))
                index = prefix[index];
            if (needle.charAt(index + 1) == haystack.charAt(i))
                index++;
            if (index == needleLength - 1)
                return i - needleLength + 1;
        }
        return -1;
    }

    public int[] prefix(String needle) {
        int length = needle.length();
        int[] prefix = new int[length];
        for (int i = 0; i < length; i++)
        	prefix[i] = -1;
        int index = -1;
        for (int i = 1; i < length; i++) {
            while (index >= 0 && needle.charAt(index + 1) != needle.charAt(i))
                index = prefix[index];
            if (needle.charAt(index + 1) == needle.charAt(i))
                index++;
            prefix[i] = index;
        }
        return prefix;
    }
}