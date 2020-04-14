/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int length = wordlist.length;
        int[][] sameCounts = new int[length][length];
        for (int i = 0; i < length; i++)
            sameCounts[i][i] = 6;
        for (int i = 0; i < length; i++) {
            String word1 = wordlist[i];
            for (int j = i + 1; j < length; j++) {
                String word2 = wordlist[j];
                sameCounts[i][j] = sameCount(word1, word2);
                sameCounts[j][i] = sameCounts[i][j];
            }
        }
        boolean[] candidates = new boolean[length];
        Arrays.fill(candidates, true);
        int index = 0;
        while (index >= 0 && index < length) {
            index = findNext(sameCounts, candidates);
            if (index < 0)
                break;
            int guessResult = master.guess(wordlist[index]);
            if (guessResult == 6)
                break;
            for (int i = 0; i < length; i++) {
                if (candidates[i] && sameCounts[index][i] != guessResult)
                    candidates[i] = false;
            }
        }
    }

    public int sameCount(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i))
                count++;
        }
        return count;
    }

    public int findNext(int[][] sameCounts, boolean[] candidates) {
        int length = candidates.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < length; i++) {
            if (candidates[i]) {
                int[] counts = new int[7];
                for (int j = 0; j < length; j++) {
                    if (j != i && candidates[j]) {
                        int count = sameCounts[i][j];
                        counts[count]++;
                    }
                }
                int max = 0;
                for (int num : counts)
                    max = Math.max(max, num);
                if (max < min) {
                    min = max;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}