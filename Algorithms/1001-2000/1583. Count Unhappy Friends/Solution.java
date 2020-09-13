class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Map<Integer, Integer>> preferencesMap = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> preferenceMap = new HashMap<Integer, Integer>();
            int[] preference = preferences[i];
            int length = preference.length;
            for (int j = 0; j < length; j++)
                preferenceMap.put(preference[j], j);
            preferencesMap.put(i, preferenceMap);
        }
        Map<Integer, Integer> pairsMap = new HashMap<Integer, Integer>();
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            pairsMap.put(person0, person1);
            pairsMap.put(person1, person0);
        }
        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            boolean flag = false;
            int y = pairsMap.get(x);
            int[] preference = preferences[x];
            Map<Integer, Integer> preferenceMapX = preferencesMap.get(x);
            int index = preferenceMapX.get(y);
            for (int i = index - 1; i >= 0; i--) {
                int u = preference[i];
                int v = pairsMap.get(u);
                Map<Integer, Integer> preferenceMapU = preferencesMap.get(u);
                int indexX = preferenceMapU.get(x);
                int indexV = preferenceMapU.get(v);
                if (indexX < indexV) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                unhappyCount++;
        }
        return unhappyCount;
    }
}