class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                if (str1.length() != str2.length())
                    return str1.length() - str2.length();
                else
                    return str1.compareTo(str2);
            }
        });
        int smallestLength = words[0].length();
        int nextLength = smallestLength + 1;
        int length = words.length;
        int[] dp = new int[length];
        int dpStartIndex = -1;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            if (words[i].length() == nextLength && dpStartIndex < 0)
                dpStartIndex = i;
        }
        if (dpStartIndex < 0)
            return 1;
        for (int i = dpStartIndex; i < length; i++) {
            String curWord = words[i];
            for (int j = i - 1; j >= 0; j--) {
                String prevWord = words[j];
                if (prevWord.length() == curWord.length())
                    continue;
                else if (prevWord.length() < curWord.length() - 1)
                    break;
                else {
                    if (isSubsequence(prevWord, curWord))
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = 0;
        for (int num : dp)
            maxLength = Math.max(maxLength, num);
        return maxLength;
    }

    public boolean isSubsequence(String str1, String str2) {
        int length1 = str1.length(), length2 = str2.length();
        if (length1 > length2)
            return false;
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            char c1 = str1.charAt(index1), c2 = str2.charAt(index2);
            if (c1 == c2)
                index1++;
            index2++;
        }
        return index1 == length1;
    }
}