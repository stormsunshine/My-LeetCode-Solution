class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        Map<String, Set<String>> firstMap = new HashMap<String, Set<String>>();
        for (String phrase : phrases) {
            int count = countMap.getOrDefault(phrase, 0) + 1;
            countMap.put(phrase, count);
            int spaceIndex = phrase.indexOf(' ');
            String first = spaceIndex >= 0 ? phrase.substring(0, spaceIndex) : phrase;
            Set<String> firstSet = firstMap.getOrDefault(first, new HashSet<String>());
            firstSet.add(phrase);
            firstMap.put(first, firstSet);
        }
        Set<String> set = new HashSet<String>();
        for (String phrase : phrases) {
            int lastSpaceIndex = phrase.lastIndexOf(' ');
            String last = lastSpaceIndex >= 0 ? phrase.substring(lastSpaceIndex + 1) : phrase;
            String prefix = lastSpaceIndex >= 0 ? phrase.substring(0, lastSpaceIndex + 1) : "";
            Set<String> firstSet = firstMap.getOrDefault(last, new HashSet<String>());
            for (String nextStr : firstSet) {
                if (nextStr.equals(phrase)) {
                    int count = countMap.getOrDefault(nextStr, 0);
                    if (count > 1) {
                        String newStr = prefix + nextStr;
                        set.add(newStr);
                    }
                } else {
                    String newStr = prefix + nextStr;
                    set.add(newStr);
                }
            }
        }
        List<String> puzzlesList = new ArrayList<String>(set);
        Collections.sort(puzzlesList);
        return puzzlesList;
    }
}