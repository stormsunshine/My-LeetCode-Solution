class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int queriesLength = queries.length, wordsLength = words.length;
        int[] queriesFrequency = new int[queriesLength];
        int[] wordsFrequency = new int[wordsLength];
        for (int i = 0; i < queriesLength; i++)
            queriesFrequency[i] = frequency(queries[i]);
        for (int i = 0; i < wordsLength; i++)
            wordsFrequency[i] = frequency(words[i]);
        int[] nums = new int[queriesLength];
        for (int i = 0; i < queriesLength; i++) {
            int queryFrequency = queriesFrequency[i];
            for (int j = 0; j < wordsLength; j++) {
                int wordFrequency = wordsFrequency[j];
                if (queryFrequency < wordFrequency)
                    nums[i]++;
            }
        }
        return nums;
    }

    public int frequency(String str) {
        int[] count = new int[26];
        char[] array = str.toCharArray();
        for (char c : array)
            count[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return count[i];
        }
        return 0;
    }
}