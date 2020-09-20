class Solution {
    public int maxUniqueSplit(String s) {
        int length = s.length();
        if (length == 1)
            return 1;
        int maxSplit = 1;
        int total = 1 << (length - 1);
        for (int i = 1; i < total; i++) {
            boolean[] split = new boolean[length - 1];
            int mask = i;
            int splitCount = 1;
            for (int j = 0; j < length - 1 && mask > 0; j++) {
                if (mask % 2 == 1) {
                    split[j] = true;
                    splitCount++;
                }
                mask /= 2;
            }
            if (splitCount > maxSplit && checkUnique(s, split, splitCount))
                maxSplit = splitCount;
        }
        return maxSplit;
    }

    public boolean checkUnique(String s, boolean[] split, int splitCount) {
        Set<String> set = new HashSet<String>();
        int start = 0;
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            if (split[i]) {
                set.add(s.substring(start, i + 1));
                start = i + 1;
            }
        }
        if (start < length)
            set.add(s.substring(start));
        return set.size() == splitCount;
    }
}