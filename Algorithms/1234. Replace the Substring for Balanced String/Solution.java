class Solution {
    public int balancedString(String s) {
        Map<Character, Integer> letterIndexMap = new HashMap<Character, Integer>();
        letterIndexMap.put('Q', 0);
        letterIndexMap.put('W', 1);
        letterIndexMap.put('E', 2);
        letterIndexMap.put('R', 3);
        int[] counts = new int[4];
        int length = s.length();
        int balanceLength = length / 4;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int index = letterIndexMap.get(c);
            counts[index]++;
        }
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (counts[i] > balanceLength) {
                counts[i] -= balanceLength;
                flag = false;
            } else
                counts[i] = 0;
        }
        if (flag)
            return 0;
        int[] actualCounts = new int[4];
        int minLength = length;
        int start = 0, end = 0;
        while (end < length) {
            char c = s.charAt(end);
            int index = letterIndexMap.get(c);
            if (counts[index] > 0) {
                actualCounts[index]++;
                if (canBalance(counts, actualCounts)) {
                    minLength = Math.min(minLength, end - start + 1);
                    while (start < end) {
                        char prevC = s.charAt(start);
                        start++;
                        int prevIndex = letterIndexMap.get(prevC);
                        if (counts[prevIndex] > 0) {
                            actualCounts[prevIndex]--;
                            if (actualCounts[prevIndex] < counts[prevIndex])
                                break;
                        }
                        minLength = Math.min(minLength, end - start + 1);
                    }
                }
            }
            end++;
        }
        return minLength;
    }

    public boolean canBalance(int[] counts, int[] actualCounts) {
        for (int i = 0; i < 4; i++) {
            if (actualCounts[i] < counts[i])
                return false;
        }
        return true;
    }
}