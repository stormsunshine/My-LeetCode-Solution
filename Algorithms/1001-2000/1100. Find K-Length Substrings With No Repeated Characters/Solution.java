class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S == null || S.length() < K)
            return 0;
        int length = S.length();
        Map<Character, Integer> letterCountMap = new HashMap<Character, Integer>();
        for (int i = 0; i < K; i++) {
            char c = S.charAt(i);
            int count = letterCountMap.getOrDefault(c, 0);
            count++;
            letterCountMap.put(c, count);
        }
        int substringsCount = 0;
        if (letterCountMap.keySet().size() == K)
            substringsCount++;
        for (int i = K; i < length; i++) {
            char prevC = S.charAt(i - K);
            char curC = S.charAt(i);
            int prevCount = letterCountMap.getOrDefault(prevC, 0);
            prevCount--;
            if (prevCount == 0)
                letterCountMap.remove(prevC);
            else
                letterCountMap.put(prevC, prevCount);
            int curCount = letterCountMap.getOrDefault(curC, 0);
            curCount++;
            letterCountMap.put(curC, curCount);
            if (letterCountMap.keySet().size() == K)
                substringsCount++;
        }
        return substringsCount;
    }
}