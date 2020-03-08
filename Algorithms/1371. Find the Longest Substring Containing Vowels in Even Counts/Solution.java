class Solution {
    public int findTheLongestSubstring(String s) {
        int[] map = new int[32];
        Arrays.fill(map, -1);
        int state = 0;
        map[state] = 0;
        int maxLength = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'a')
                state ^= (1 << 0);
            else if (c == 'e')
                state ^= (1 << 1);
            else if (c == 'i')
                state ^= (1 << 2);
            else if (c == 'o')
                state ^= (1 << 3);
            else if (c == 'u')
                state ^= (1 << 4);
            if (map[state] >= 0)
                maxLength = Math.max(maxLength, i + 1 - map[state]);
            else
                map[state] = i + 1;
        }
        return maxLength;
    }
}