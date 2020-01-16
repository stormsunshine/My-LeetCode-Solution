class Solution {
    public int firstUniqChar(String s) {
        int length = s.length();
        Map<Integer, Character> indexLetterMap = new HashMap<Integer, Character>();
        Map<Character, List<Integer>> letterIndicesMap = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            indexLetterMap.put(i, c);
            List<Integer> indices = letterIndicesMap.getOrDefault(c, new ArrayList<Integer>());
            indices.add(i);
            letterIndicesMap.put(c, indices);
        }
        for (int i = 0; i < length; i++) {
            char c = indexLetterMap.get(i);
            List<Integer> indices = letterIndicesMap.getOrDefault(c, new ArrayList<Integer>());
            if (indices.size() == 1)
                return i;
        }
        return -1;
    }
}