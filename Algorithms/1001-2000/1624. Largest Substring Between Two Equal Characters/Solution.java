class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int prevIndex = map.get(c);
                maxLength = Math.max(maxLength, i - prevIndex - 1);
            } else
                map.put(c, i);
        }
        return maxLength;
    }
}