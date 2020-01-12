class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10)
            return new ArrayList<String>();
        Set<String> visitedSet = new HashSet<String>();
        Set<String> repeatedSet = new HashSet<String>();
        int length = s.length();
        int maxBegin = length - 10;
        for (int i = 0; i <= maxBegin; i++) {
            String substring = s.substring(i, i + 10);
            if (!visitedSet.add(substring))
                repeatedSet.add(substring);
        }
        return new ArrayList<String>(repeatedSet);
    }
}