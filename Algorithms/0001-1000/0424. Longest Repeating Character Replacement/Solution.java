class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxCount = 0;
        int low = 0, high = 0;
        int length = s.length();
        while (high < length) {
            char highC = s.charAt(high);
            int highCount = map.getOrDefault(highC, 0);
            highCount++;
            map.put(highC, highCount);
            maxCount = Math.max(maxCount, highCount);
            if (high - low + 1 > maxCount + k) {
                char lowC = s.charAt(low);
                int lowCount = map.getOrDefault(lowC, 0);
                lowCount--;
                if (lowCount > 0)
                    map.put(lowC, lowCount);
                else
                    map.remove(lowC);
                low++;
            }
            high++;
        }
        return length - low;
    }
}