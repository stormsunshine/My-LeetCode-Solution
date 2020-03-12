class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        int maxLength = 0;
        int begin = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int index = map.getOrDefault(c, -1);
            if (index < 0) {
                map.put(c, i);
                maxLength = Math.max(maxLength, i + 1 - begin);
            } else {
                map.put(c, i);
                begin = Math.max(begin, index + 1);
                maxLength = Math.max(maxLength, i + 1 - begin);
            }
        }
        return maxLength;
    }
}