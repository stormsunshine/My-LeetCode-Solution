class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] punctuationsArray = {"!", "\\?", "\'", ",", ";", "\\."};
        for (String punctuation : punctuationsArray)
            paragraph = paragraph.replaceAll(punctuation, " ");
        while (paragraph.indexOf("  ") >= 0)
            paragraph = paragraph.replaceAll("  ", " ");
        Set<String> bannedSet = new HashSet<String>();
        for (String word : banned)
            bannedSet.add(word);
        String mostCommonWord = "";
        int maxFrequency = 0;
        Map<String, Integer> wordFrequencyMap = new HashMap<String, Integer>();
        String[] paragraphArray = paragraph.split(" ");
        for (String word : paragraphArray) {
            if (bannedSet.contains(word))
                continue;
            int frequency = wordFrequencyMap.getOrDefault(word, 0);
            frequency++;
            wordFrequencyMap.put(word, frequency);
            if (frequency > maxFrequency) {
                mostCommonWord = word;
                maxFrequency = frequency;
            }
        }
        return mostCommonWord;
    }
}