class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int maxScore = 0;
        int[] available = new int[26];
        for (char letter : letters)
            available[letter - 'a']++;
        int length = words.length;
        int states = 1 << length;
        for (int i = 1; i < states; i++) {
            int[] bits = numToBits(i, length);
            if (possible(words, bits, available)) {
                int curScore = calculateScore(words, bits, score);
                maxScore = Math.max(maxScore, curScore);
            }
        }
        return maxScore;
    }

    public int[] numToBits(int num, int length) {
        int[] bits = new int[length];
        for (int i = 0; i < length; i++) {
            bits[i] = num % 2;
            num /= 2;
            if (num == 0)
                break;
        }
        return bits;
    }

    public boolean possible(String[] words, int[] bits, int[] available) {
        int[] counts = new int[26];
        int length = words.length;
        for (int i = 0; i < length; i++) {
            if (bits[i] == 1) {
                String word = words[i];
                int wordLength = word.length();
                for (int j = 0; j < wordLength; j++) {
                    char letter = word.charAt(j);
                    counts[letter - 'a']++;
                    if (counts[letter - 'a'] > available[letter - 'a'])
                        return false;
                }
            }
        }
        return true;
    }

    public int calculateScore(String[] words, int[] bits, int[] score) {
        int totalScore = 0;
        int length = words.length;
        for (int i = 0; i < length; i++) {
            if (bits[i] == 1) {
                String word = words[i];
                int wordLength = word.length();
                for (int j = 0; j < wordLength; j++) {
                    char letter = word.charAt(j);
                    totalScore += score[letter - 'a'];
                }
            }
        }
        return totalScore;
    }
}