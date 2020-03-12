class Solution {
    public String originalDigits(String s) {
        String[] wordsArray = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] numsInOrder = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int[] counts = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++)
            counts[s.charAt(i) - 'a']++;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int num = numsInOrder[i];
            String word = wordsArray[num];
            int[] curCounts = new int[26];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++)
                curCounts[word.charAt(j) - 'a']++;
            int digitCount = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (curCounts[j] > 0)
                    digitCount = Math.min(digitCount, counts[j] / curCounts[j]);
            }
            for (int j = 0; j < digitCount; j++)
                sb.append(num);
            for (int j = 0; j < 26; j++) {
                if (curCounts[j] > 0)
                    counts[j] -= curCounts[j] * digitCount;
            }
        }
        char[] digitsArray = sb.toString().toCharArray();
        Arrays.sort(digitsArray);
        return new String(digitsArray);
    }
}