class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] licenseCount = new int[26];
        char[] licenseArray = licensePlate.toCharArray();
        for (char c : licenseArray) {
            if (Character.isLetter(c))
                licenseCount[c - 'a']++;
        }
        int minIndex = -1;
        int length = words.length;
        for (int i = 0; i < length; i++) {
            if (isComplete(licenseCount, words[i])) {
                if (minIndex < 0 || words[i].length() < words[minIndex].length())
                    minIndex = i;
            }
        }
        return minIndex < 0 ? "" : words[minIndex];
    }

    public boolean isComplete(int[] licenseCount, String word) {
        int[] wordCount = new int[26];
        char[] wordArray = word.toCharArray();
        for (char c : wordArray)
            wordCount[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (licenseCount[i] > wordCount[i])
                return false;
        }
        return true;
    }
}