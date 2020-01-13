class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null)
            return false;
        int length1 = s.length(), length2 = t.length();
        if (length1 != length2)
            return false;
        if (length1 == 0)
            return true;
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i = 0; i < length1; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map1.get(c1) == null)
                map1.put(c1, c2);
            else if (map1.get(c1) != c2)
                return false;
            if (map2.get(c2) == null)
                map2.put(c2, c1);
            else if (map2.get(c2) != c1)
                return false;
        }
        return true;
    }
}