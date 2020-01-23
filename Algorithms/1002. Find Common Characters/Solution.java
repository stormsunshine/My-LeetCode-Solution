class Solution {
    public List<String> commonChars(String[] A) {
        int[] countsIntersection = new int[26];
        for (int i = 0; i < 26; i++)
            countsIntersection[i] = Integer.MAX_VALUE;
        for (String str : A) {
            int[] counts = new int[26];
            char[] array = str.toCharArray();
            for (char c : array)
                counts[c - 'a']++;
            for (int i = 0; i < 26; i++)
                countsIntersection[i] = Math.min(countsIntersection[i], counts[i]);
        }
        List<String> letters = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            String curLetter = String.valueOf((char) ('a' + i));
            int curCount = countsIntersection[i];
            for (int j = 0; j < curCount; j++)
                letters.add(curLetter);
        }
        return letters;
    }
}