class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matchWords = new ArrayList<String>();
        for (String word : words) {
            if (matchPattern(word, pattern))
                matchWords.add(word);
        }
        return matchWords;
    }

    public boolean matchPattern(String word, String pattern) {
        if (word.length() != pattern.length())
            return false;
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c1 = word.charAt(i), c2 = pattern.charAt(i);
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2)
                    return false;
            } else
                map1.put(c1, c2);
            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1)
                    return false;
            } else
                map2.put(c2, c1);
        }
        return true;
    }
}