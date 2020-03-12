class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> universalList = new ArrayList<String>();
        int[] counts = getMaxCounts(B);
        for (String word : A) {
            int[] wordCounts = getWordCounts(word);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (wordCounts[i] < counts[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                universalList.add(word);
        }
        return universalList;
    }

    public int[] getMaxCounts(String[] array) {
        int[] counts = new int[26];
        for (String word : array) {
            int[] curCounts = new int[26];
            char[] wordArray = word.toCharArray();
            for (char c : wordArray)
                curCounts[c - 'a']++;
            for (int i = 0; i < 26; i++)
                counts[i] = Math.max(counts[i], curCounts[i]);
        }
        return counts;
    }

    public int[] getWordCounts(String word) {
        int[] wordCounts = new int[26];
        char[] wordArray = word.toCharArray();
        for (char c : wordArray)
            wordCounts[c - 'a']++;
        return wordCounts;
    }
}