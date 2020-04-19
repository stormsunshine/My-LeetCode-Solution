class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int length = croakOfFrogs.length();
        if (length % 5 != 0)
            return -1;
        Map<Character, Integer> letterIndexMap = new HashMap<Character, Integer>();
        String croak = "croak";
        for (int i = 0; i < 5; i++)
            letterIndexMap.put(croak.charAt(i), i);
        int curSize = 0;
        int maxSize = 0;
        int[] counts = new int[5];
        for (int i = 0; i < length; i++) {
            char c = croakOfFrogs.charAt(i);
            int index = letterIndexMap.get(c);
            if (index == 0) {
                counts[index]++;
                curSize++;
                maxSize = Math.max(maxSize, curSize);
            } else {
                counts[index - 1]--;
                if (counts[index - 1] < 0)
                    return -1;
                if (index < 4)
                    counts[index]++;
                else
                    curSize--;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (counts[i] != 0)
                return -1;
        }
        return maxSize;
    }
}