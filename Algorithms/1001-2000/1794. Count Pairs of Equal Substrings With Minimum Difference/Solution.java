class Solution {
    public int countQuadruples(String firstString, String secondString) {
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        int length1 = firstString.length(), length2 = secondString.length();
        for (int i = length1 - 1; i >= 0; i--) {
            char c = firstString.charAt(i);
            map1.put(c, i);
        }
        for (int i = 0; i < length2; i++) {
            char c = secondString.charAt(i);
            map2.put(c, i);
        }
        int minDifference = Integer.MAX_VALUE;
        Set<Character> keySet = map1.keySet();
        for (char c : keySet) {
            int index1 = map1.get(c);
            if (map2.containsKey(c)) {
                int index2 = map2.get(c);
                int difference = index1 - index2;
                minDifference = Math.min(minDifference, difference);
            }
        }
        if (minDifference == Integer.MAX_VALUE)
            return 0;
        int quadruples = 0;
        for (char c : keySet) {
            int index1 = map1.get(c);
            if (map2.containsKey(c)) {
                int index2 = map2.get(c);
                int difference = index1 - index2;
                if (difference == minDifference)
                    quadruples++;
            }
        }
        return quadruples;
    }
}