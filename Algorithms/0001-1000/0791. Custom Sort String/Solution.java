class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int sLength = S.length(), tLength = T.length();
        for (int i = 0; i < sLength; i++)
            map.put(S.charAt(i), i);
        char[] tArray = T.toCharArray();
        Character[] sortedArray = new Character[tLength];
        for (int i = 0; i < tLength; i++)
            sortedArray[i] = tArray[i];
        Arrays.sort(sortedArray, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                int order1 = map.getOrDefault(c1, 100);
                int order2 = map.getOrDefault(c2, 100);
                return order1 - order2;
            }
        });
        for (int i = 0; i < tLength; i++)
            tArray[i] = sortedArray[i];
        return new String(tArray);
    }
}