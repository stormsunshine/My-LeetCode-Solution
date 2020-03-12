class Solution {
    public int shortestWay(String source, String target) {
        int count = 0;
        int targetLength = target.length();
        int startIndex = 0;
        while (startIndex < targetLength) {
            startIndex = longestSubsequence(source, target, startIndex);
            if (startIndex < 0)
                return -1;
            else
                count++;
        }
        return count;
    }

    public int longestSubsequence(String source, String target, int startIndex) {
        int sourceLength = source.length(), targetLength = target.length();
        int sourceIndex = 0, targetIndex = startIndex;
        while (sourceIndex < sourceLength && targetIndex < targetLength) {
            char c1 = source.charAt(sourceIndex), c2 = target.charAt(targetIndex);
            if (c1 == c2)
                targetIndex++;
            sourceIndex++;
        }
        if (targetIndex == startIndex)
            return -1;
        else
            return targetIndex;
    }
}