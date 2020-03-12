class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return indices;
        int length = s.length();
        int wordLength = words[0].length();
        int substringLength = wordLength * words.length;
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
        for (String word : words) {
            int count = wordCountMap.getOrDefault(word, 0);
            count++;
            wordCountMap.put(word, count);
        }
        int maxStart = length - substringLength;
        for (int i = 0; i <= maxStart; i++) {
            String substr = s.substring(i, i + substringLength);
            if (match(substr, wordCountMap, wordLength))
                indices.add(i);
        }
        return indices;
    }

    public boolean match(String str, Map<String, Integer> wordCountMap, int wordLength) {
        Map<String, Integer> curMap = new HashMap<String, Integer>();
        int length = str.length();
        for (int i = 0; i < length; i += wordLength) {
            String substr = str.substring(i, i + wordLength);
            if (!wordCountMap.containsKey(substr))
                return false;
            int count = curMap.getOrDefault(substr, 0);
            count++;
            if (count > wordCountMap.get(substr))
                return false;
            curMap.put(substr, count);
        }
        return true;
    }
}