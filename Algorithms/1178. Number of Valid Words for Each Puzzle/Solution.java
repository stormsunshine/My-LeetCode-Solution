class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> validCounts = new ArrayList<Integer>();
        Map<Integer, Integer> wordCountMap = new HashMap<Integer, Integer>();
        int puzzlesLength = puzzles.length;
        for (String word : words) {
            int bits = 0;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                bits |= 1 << c - 'a';
            }
            int count = wordCountMap.getOrDefault(bits, 0) + 1;
            wordCountMap.put(bits, count);
        }
        for (int i = 0; i < puzzlesLength; i++) {
            int wordsCount = 0;
            int bits = 0;
            String puzzle = puzzles[i];
            int length = puzzle.length();
            for (int j = 0; j < length; j++) {
                char c = puzzle.charAt(j);
                bits |= 1 << c - 'a';
            }
            char c0 = puzzle.charAt(0);
            for (int j = bits; j > 0; j = (j - 1) & bits) {
                if (((1 << c0 - 'a') & j) > 0)
                    wordsCount += wordCountMap.getOrDefault(j, 0);
            }
            validCounts.add(wordsCount);
        }
        return validCounts;
    }
}