class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> substringCountsMap = new HashMap<String, Integer>();
        int length = s.length();
        int maxBegin = length - minSize;
        for (int i = 0; i <= maxBegin; i++) {
            Map<Character, Integer> lettersCountMap = new HashMap<Character, Integer>();
            boolean flag = true;
            for (int j = 0; j < minSize - 1; j++) {
                char c = s.charAt(i + j);
                int count = lettersCountMap.getOrDefault(c, 0);
                count++;
                lettersCountMap.put(c, count);
                if (lettersCountMap.keySet().size() > maxLetters) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                continue;
            for (int j = i + minSize; j <= Math.min(i + maxSize, length); j++) {
                char curC = s.charAt(j - 1);
                int count = lettersCountMap.getOrDefault(curC, 0);
                count++;
                lettersCountMap.put(curC, count);
                if (lettersCountMap.keySet().size() > maxLetters) {
                    flag = false;
                    break;
                }
                String substring = s.substring(i, j);
                int substringCount = substringCountsMap.getOrDefault(substring, 0);
                substringCount++;
                substringCountsMap.put(substring, substringCount);
            }
        }
        Set<String> substringSet = substringCountsMap.keySet();
        int maxCount = 0;
        for (String substring : substringSet) {
            int count = substringCountsMap.getOrDefault(substring, 0);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}