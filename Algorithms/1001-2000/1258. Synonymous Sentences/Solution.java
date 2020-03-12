class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Set<String>> synonymsMap = new HashMap<String, Set<String>>();
        for (List<String> synonymsPair : synonyms) {
            String word1 = synonymsPair.get(0), word2 = synonymsPair.get(1);
            Set<String> synonymsSet1 = synonymsMap.getOrDefault(word1, new HashSet<String>(Arrays.asList(word1)));
            Set<String> synonymsSet2 = synonymsMap.getOrDefault(word2, new HashSet<String>(Arrays.asList(word2)));
            Set<String> synonymsSetUnion = new HashSet<String>(synonymsSet1);
            synonymsSetUnion.addAll(synonymsSet2);
            for (String word : synonymsSetUnion)
                synonymsMap.put(word, synonymsSetUnion);
        }
        List<String> sentencesList = new ArrayList<String>();
        sentencesList.add(text);
        String[] sentenceArray = text.split(" ");
        Set<Integer> synonymsIndicesSet = new HashSet<Integer>();
        int length = sentenceArray.length;
        for (int i = 0; i < length; i++) {
            String word = sentenceArray[i];
            if (synonymsMap.containsKey(word))
                synonymsIndicesSet.add(i);
        }
        for (int i = 0; i < length; i++) {
            if (synonymsIndicesSet.contains(i))
                generateSentencesWithIndex(sentencesList, i, sentenceArray[i], synonymsMap);
        }
        Collections.sort(sentencesList);
        return sentencesList;
    }

    public void generateSentencesWithIndex(List<String> sentencesList, int index, String word, Map<String, Set<String>> synonymsMap) {
        Set<String> synonymsSet = synonymsMap.getOrDefault(word, new HashSet<String>());
        int size = sentencesList.size();
        for (int i = 0; i < size; i++) {
            String prevSentence = sentencesList.get(i);
            String[] array = prevSentence.split(" ");
            int length = array.length;
            for (String synonymsWord : synonymsSet) {
                if (!synonymsWord.equals(word)) {
                    array[index] = synonymsWord;
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j < length; j++)
                        sb.append(array[j] + " ");
                    String newSentence = sb.toString().trim();
                    sentencesList.add(newSentence);
                }
            }
        }
    }
}