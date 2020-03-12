class Solution {
    public String minWindow(String s, String t) {
        int minStartIndex = -1, minEndIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int sLength = s.length(), tLength = t.length();
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            int count = tMap.getOrDefault(c, 0);
            count++;
            tMap.put(c, count);
        }
        int distinctLetters = tMap.size();
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        int meetLetters = 0;
        int startIndex = 0, endIndex = 0;
        while (endIndex < sLength) {
            char c = s.charAt(endIndex);
            endIndex++;
            if (!tMap.containsKey(c))
                continue;
            int count = sMap.getOrDefault(c, 0);
            count++;
            sMap.put(c, count);
            if (count == tMap.get(c))
                meetLetters++;
            if (meetLetters == distinctLetters) {
                int windowLength = endIndex - startIndex;
                if (windowLength < minLength) {
                    minStartIndex = startIndex;
                    minEndIndex = endIndex;
                    minLength = windowLength;
                }
                while (startIndex < endIndex) {
                    char removeC = s.charAt(startIndex);
                    startIndex++;
                    if (!tMap.containsKey(removeC)) {
                        windowLength = endIndex - startIndex;
                        if (windowLength < minLength) {
                            minStartIndex = startIndex;
                            minEndIndex = endIndex;
                            minLength = windowLength;
                        }
                    } else {
                        int removeCount = sMap.getOrDefault(removeC, 0);
                        removeCount--;
                        sMap.put(removeC, removeCount);
                        if (removeCount >= tMap.get(removeC)) {
                            windowLength = endIndex - startIndex;
                            if (windowLength < minLength) {
                                minStartIndex = startIndex;
                                minEndIndex = endIndex;
                                minLength = windowLength;
                            }
                        } else {
                            meetLetters--;
                            break;
                        }
                    }
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStartIndex, minEndIndex);
    }
}