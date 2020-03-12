class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        Map<Integer, int[]> countsMap = new HashMap<Integer, int[]>();
        int[] counts = new int[26];
        char c0 = s.charAt(0);
        counts[c0 - 'a']++;
        countsMap.put(0, counts);
        int length = s.length();
        for (int i = 1; i < length; i++) {
            int[] prevCounts = countsMap.get(i - 1);
            int[] curCounts = new int[26];
            System.arraycopy(prevCounts, 0, curCounts, 0, 26);
            char c = s.charAt(i);
            curCounts[c - 'a']++;
            countsMap.put(i, curCounts);
        }
        List<Boolean> booleanList = new ArrayList<Boolean>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], k = query[2];
            boolean canMake = canMakePalindrome(countsMap, left, right, k);
            booleanList.add(canMake);
        }
        return booleanList;
    }

    public boolean canMakePalindrome(Map<Integer, int[]> countsMap, int left, int right, int k) {
        int[] counts = countsMap.get(right);
        int[] curCounts = new int[26];
        System.arraycopy(counts, 0, curCounts, 0, 26);
        if (left > 0) {
            int[] prevCounts = countsMap.get(left - 1);
            for (int i = 0; i < 26; i++)
                curCounts[i] -= prevCounts[i];
        }
        int oddCounts = 0;
        for (int i = 0; i < 26; i++) {
            if (curCounts[i] % 2 != 0)
                oddCounts++;
        }
        return oddCounts / 2 <= k;
    }
}