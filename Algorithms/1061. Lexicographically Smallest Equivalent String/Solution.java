class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        Map<Character, Character> letterGroupMap = new HashMap<Character, Character>();
        Map<Character, Set<Character>> groupLettersMap = new HashMap<Character, Set<Character>>();
        for (char c = 'a'; c <= 'z'; c++) {
            letterGroupMap.put(c, c);
            Set<Character> set = new HashSet<Character>();
            set.add(c);
            groupLettersMap.put(c, set);
        }
        int length = A.length();
        for (int i = 0; i < length; i++) {
            char c1 = A.charAt(i), c2 = B.charAt(i);
            char group1 = letterGroupMap.get(c1), group2 = letterGroupMap.get(c2);
            if (group1 != group2) {
                Set<Character> set1 = groupLettersMap.get(group1);
                Set<Character> set2 = groupLettersMap.get(group2);
                if (group1 < group2) {
                    for (char c : set2)
                        letterGroupMap.put(c, group1);
                    set1.addAll(set2);
                    groupLettersMap.put(group1, set1);
                    groupLettersMap.remove(group2);
                } else {
                    for (char c : set1)
                        letterGroupMap.put(c, group2);
                    set2.addAll(set1);
                    groupLettersMap.put(group2, set2);
                    groupLettersMap.remove(group1);
                }
            }
        }
        char[] array = S.toCharArray();
        int strLength = array.length;
        for (int i = 0; i < strLength; i++) {
            char c = array[i];
            char group = letterGroupMap.get(c);
            array[i] = group;
        }
        return new String(array);
    }
}