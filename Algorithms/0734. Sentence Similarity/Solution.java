class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null || words2 == null)
            return false;
        if (words1.length != words2.length)
            return false;
        Map<String, List<String>> similarMap = new HashMap<String, List<String>>();
        for (List<String> pair : pairs) {
            String word1 = pair.get(0), word2 = pair.get(1);
            if (word1.equals(word2))
                continue;
            List<String> similar1 = similarMap.getOrDefault(word1, new ArrayList<String>());
            if (!similar1.contains(word2)) {
                similar1.add(word2);
                similarMap.put(word1, similar1);
            }
            List<String> similar2 = similarMap.getOrDefault(word2, new ArrayList<String>());
            if (!similar2.contains(word1)) {
                similar2.add(word1);
                similarMap.put(word2, similar2);
            }
        }
        int length = words1.length;
        for (int i = 0; i < length; i++) {
            String word1 = words1[i], word2 = words2[i];
            if (word1.equals(word2))
                continue;
            List<String> similar1 = similarMap.getOrDefault(word1, new ArrayList<String>());
            if (!similar1.contains(word2))
                return false;
        }
        return true;
    }
}