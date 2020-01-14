class Solution {
    public boolean wordPattern(String pattern, String str) {
        str = str.trim();
        String[] words = str.split(" ");
        if (pattern.length() != words.length)
            return false;
        int length = words.length;
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (map1.containsKey(c) && !map1.get(c).equals(word))
                return false;
            if (map2.containsKey(word) && map2.get(word) != c)
                return false;
            map1.put(c, word);
            map2.put(word, c);
        }
        return true;
    }
}