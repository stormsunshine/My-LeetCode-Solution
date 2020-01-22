class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> uncommonWords = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        String[] strA = A.split(" ");
        String[] strB = B.split(" ");
        for (String word : strA) {
            if (set.add(word))
                uncommonWords.add(word);
            else
                uncommonWords.remove(word);
        }
        for (String word : strB) {
            if (set.add(word))
                uncommonWords.add(word);
            else
                uncommonWords.remove(word);
        }
        int length = uncommonWords.size();
        String[] uncommonWordsArray = new String[length];
        for (int i = 0; i < length; i++)
            uncommonWordsArray[i] = uncommonWords.get(i);
        return uncommonWordsArray;
    }
}