class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, String> strCountMap = new HashMap<String, String>();
        Map<String, Integer> countGroupMap = new HashMap<String, Integer>();
        int anagramsCount = 0;
        for (String str : strs) {
            int[] lettersCounts = getLettersCounts(str);
            String arrayStr = Arrays.toString(lettersCounts);
            strCountMap.put(str, arrayStr);
            if (!countGroupMap.containsKey(arrayStr)) {
                countGroupMap.put(arrayStr, anagramsCount);
                anagramsCount++;
            }
        }
        List<List<String>> anagramsGroups = new ArrayList<List<String>>();
        for (int i = 0; i < anagramsCount; i++)
            anagramsGroups.add(new ArrayList<String>());
        for (String str : strs) {
            int[] lettersCounts = getLettersCounts(str);
            String arrayStr = Arrays.toString(lettersCounts);
            int group = countGroupMap.get(arrayStr);
            anagramsGroups.get(group).add(str);
        }
        return anagramsGroups;
    }

    public int[] getLettersCounts(String str) {
        int[] counts = new int[26];
        char[] array = str.toCharArray();
        for (char c : array)
            counts[c - 'a']++;
        return counts;
    }
}