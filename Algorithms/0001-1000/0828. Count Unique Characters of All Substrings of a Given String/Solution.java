class Solution {
    public int uniqueLetterString(String s) {
        final int MODULO = 1000000007;
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            List<Integer> indices = map.getOrDefault(c, new ArrayList<Integer>());
            indices.add(i);
            map.put(c, indices);
        }
        int count = 0;
        Set<Character> keySet = map.keySet();
        for (char c : keySet) {
            List<Integer> indices = map.get(c);
            int size = indices.size();
            for (int i = 0; i < size; i++) {
                int currIndex = indices.get(i);
                int prevIndex = i > 0 ? indices.get(i - 1) : -1;
                int nextIndex = i < size - 1 ? indices.get(i + 1) : length;
                count = (count + (currIndex - prevIndex) * (nextIndex - currIndex)) % MODULO;
            }
        }
        return count;
    }
}