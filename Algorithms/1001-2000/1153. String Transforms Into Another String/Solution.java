class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        if (str1.equals(str2))
            return true;
        Set<Character> set = new HashSet<Character>();
        int length = str1.length();
        for (int i = 0; i < length; i++)
            set.add(str2.charAt(i));
        if (set.size() == 26)
            return false;
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < length; i++) {
            char c = str1.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<Integer>());
            list.add(i);
            map.put(c, list);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            List<Integer> list = map.getOrDefault(c, new ArrayList<Integer>());
            int size = list.size();
            for (int i = 1; i < size; i++) {
                int prevIndex = list.get(i - 1), currIndex = list.get(i);
                if (str2.charAt(prevIndex) != str2.charAt(currIndex))
                    return false;
            }
        }
        return true;
    }
}