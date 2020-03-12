class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<Character, Integer>();
        for (int i = 0; i < 26; i++) {
            char c = order.charAt(i);
            orderMap.put(c, i);
        }
        int length = words.length;
        for (int i = 1; i < length; i++) {
            if (compare(words[i - 1], words[i], orderMap) > 0)
                return false;
        }
        return true;
    }

    public int compare(String word1, String word2, Map<Character, Integer> orderMap) {
        if (word1.equals(word2))
            return 0;
        int length1 = word1.length(), length2 = word2.length();
        int minLength = Math.min(length1, length2);
        for (int i = 0; i < minLength; i++) {
            char c1 = word1.charAt(i), c2 = word2.charAt(i);
            int order1 = orderMap.get(c1), order2 = orderMap.get(c2);
            if (order1 != order2)
                return order1 - order2;
        }
        return length1 > length2 ? 1 : -1;
    }
}