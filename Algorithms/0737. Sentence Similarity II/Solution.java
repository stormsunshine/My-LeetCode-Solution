class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length)
            return false;
        Map<String, Integer> wordGroupMap = new HashMap<String, Integer>();
        Map<Integer, List<String>> groupWordsMap = new HashMap<Integer, List<String>>();
        int groupCount = 0;
        for (List<String> pair : pairs) {
            String word1 = pair.get(0), word2 = pair.get(1);
            int group1 = wordGroupMap.getOrDefault(word1, -1), group2 = wordGroupMap.getOrDefault(word2, -1);
            if (group1 < 0 && group2 < 0) {
                wordGroupMap.put(word1, groupCount);
                wordGroupMap.put(word2, groupCount);
                List<String> list = groupWordsMap.getOrDefault(groupCount, new ArrayList<String>());
                list.add(word1);
                list.add(word2);
                groupWordsMap.put(groupCount, list);
                groupCount++;
            } else if (group2 < 0) {
                wordGroupMap.put(word2, group1);
                List<String> list = groupWordsMap.getOrDefault(group1, new ArrayList<String>());
                list.add(word2);
                groupWordsMap.put(group1, list);
            } else if (group1 < 0) {
                wordGroupMap.put(word1, group2);
                List<String> list = groupWordsMap.getOrDefault(group2, new ArrayList<String>());
                list.add(word1);
                groupWordsMap.put(group2, list);
            } else {
                if (group1 == group2)
                    continue;
                List<String> list1 = groupWordsMap.getOrDefault(group1, new ArrayList<String>());
                List<String> list2 = groupWordsMap.getOrDefault(group2, new ArrayList<String>());
                if (group1 < group2) {
                    list1.addAll(list2);
                    for (String word : list2)
                        wordGroupMap.put(word, group1);
                    groupWordsMap.put(group1, list1);
                    groupWordsMap.remove(group2);
                } else {
                    list2.addAll(list1);
                    for (String word : list1)
                        wordGroupMap.put(word, group2);
                    groupWordsMap.put(group2, list2);
                    groupWordsMap.remove(group1);
                }
            }
        }
        int length = words1.length;
        for (int i = 0; i < length; i++) {
            String word1 = words1[i], word2 = words2[i];
            if (word1.equals(word2))
                continue;
            int group1 = wordGroupMap.getOrDefault(word1, -1), group2 = wordGroupMap.getOrDefault(word2, -1);
            if (group1 < 0 || group2 < 0 || group1 != group2)
                return false;
        }
        return true;
    }
}