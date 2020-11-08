class Solution {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++)
            counts[s.charAt(i) - 'a']++;
        List<Integer> countsList = new ArrayList<Integer>();
        Set<Integer> countsSet = new HashSet<Integer>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                countsList.add(counts[i]);
                countsSet.add(counts[i]);
            }
        }
        Collections.sort(countsList);
        int deletions = 0;
        int size = countsList.size();
        int curCount = countsList.get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            int count = countsList.get(i);
            if (count == countsList.get(i + 1)) {
                curCount = Math.min(curCount, count - 1);
                while (curCount > 0 && countsSet.contains(curCount))
                    curCount--;
                countsSet.add(curCount);
                deletions += count - curCount;
            }
        }
        return deletions;
    }
}