class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null)
            return 0;
        int length = s.length();
        if (length <= 2)
            return length;
        int maxLength = 2;
        Map<Character, Integer> characterCountsMap = new HashMap<Character, Integer>();
        int begin = 0, end = 1;
        characterCountsMap.put(s.charAt(0), 1);
        while (end < length) {
            char c = s.charAt(end);
            int count = characterCountsMap.getOrDefault(c, 0);
            count++;
            characterCountsMap.put(c, count);
            while (characterCountsMap.keySet().size() > 2) {
                char frontC = s.charAt(begin);
                int frontCount = characterCountsMap.get(frontC);
                frontCount--;
                if (frontCount > 0)
                    characterCountsMap.put(frontC, frontCount);
                else
                    characterCountsMap.remove(frontC);
                begin++;
            }
            maxLength = Math.max(maxLength, end - begin + 1);
            end++;
        }
        return maxLength;
    }
}