class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom == null || bottom.length() == 0)
            return false;
        if (bottom.length() == 1)
            return true;
        Map<String, Set<Character>> allowedMap = new HashMap<String, Set<Character>>();
        for (String str : allowed) {
            String key = str.substring(0, 2);
            char value = str.charAt(2);
            Set<Character> allowedSet = allowedMap.getOrDefault(key, new HashSet<Character>());
            allowedSet.add(value);
            allowedMap.put(key, allowedSet);
        }
        return pyramidTransition(bottom, allowedMap);
    }

    public boolean pyramidTransition(String bottom, Map<String, Set<Character>> allowedMap) {
        int length = bottom.length();
        if (length == 1)
            return true;
        List<String> next = new ArrayList<String>();
        for (int i = 0; i < length - 1; i++) {
            String substr = bottom.substring(i, i + 2);
            if (!allowedMap.containsKey(substr))
                return false;
            else {
                int size = next.size();
                if (size == 0) {
                    Set<Character> set = allowedMap.get(substr);
                    for (char letter : set)
                        next.add(String.valueOf(letter));
                } else{
                    while (size > 0) {
                        Set<Character> set = allowedMap.get(substr);
                        for (char letter : set)
                            next.add(next.get(0) + letter);
                        next.remove(0);
                        size--;
                    }
                }
            }
        }
        for (String str : next) {
            if (pyramidTransition(str, allowedMap))
                return true;
        }
        return false;
    }
}