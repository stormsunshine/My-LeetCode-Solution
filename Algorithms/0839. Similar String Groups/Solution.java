class Solution {
    public int numSimilarGroups(String[] A) {
        Map<String, Integer> stringGroupMap = new HashMap<String, Integer>();
        Map<Integer, Set<String>> groupSetMap = new HashMap<Integer, Set<String>>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (stringGroupMap.containsKey(A[i]))
                continue;
            stringGroupMap.put(A[i], i);
            Set<String> set = new HashSet<String>();
            set.add(A[i]);
            groupSetMap.put(i, set);
        }
        for (int i = 0; i < length; i++) {
            String str1 = A[i];
            for (int j = i + 1; j < length; j++) {
                String str2 = A[j];
                if (difference(str1, str2) <= 2) {
                    int group1 = stringGroupMap.get(str1);
                    int group2 = stringGroupMap.get(str2);
                    if (group1 == group2)
                        continue;
                    Set<String> set1 = groupSetMap.get(group1);
                    Set<String> set2 = groupSetMap.get(group2);
                    if (group1 < group2) {
                        set1.addAll(set2);
                        for (String str : set1)
                            stringGroupMap.put(str, group1);
                        groupSetMap.put(group1, set1);
                        groupSetMap.remove(group2);
                    } else {
                        set2.addAll(set1);
                        for (String str : set2)
                            stringGroupMap.put(str, group2);
                        groupSetMap.put(group2, set2);
                        groupSetMap.remove(group1);
                    }
                }
            }
        }
        return groupSetMap.size();
    }

    public int difference(String str1, String str2) {
        int difference = 0;
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                difference++;
        }
        return difference;
    }
}