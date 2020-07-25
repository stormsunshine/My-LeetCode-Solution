class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int count = map2.getOrDefault(c, 0) + 1;
            map2.put(c, count);
        }
        int goodSplits = 0;
        for (int i = 0; i < length - 1; i++) {
            char c = s.charAt(i);
            int count1 = map1.getOrDefault(c, 0) + 1;
            map1.put(c, count1);
            int count2 = map2.get(c) - 1;
            if (count2 > 0)
                map2.put(c, count2);
            else
                map2.remove(c);
            if (map1.size() == map2.size())
                goodSplits++;
            else if (map1.size() > map2.size())
                break;
        }
        return goodSplits;
    }
}