class Solution {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare(int[] log1, int[] log2) {
                return log1[0] - log2[0];
            }
        });
        Map<Integer, Integer> personGroupMap = new HashMap<Integer, Integer>();
        Map<Integer, Set<Integer>> groupSetMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < N; i++) {
            personGroupMap.put(i, i);
            Set<Integer> set = new HashSet<Integer>();
            set.add(i);
            groupSetMap.put(i, set);
        }
        int length = logs.length;
        for (int i = 0; i < length; i++) {
            int[] log = logs[i];
            int timestamp = log[0], person1 = log[1], person2 = log[2];
            if (person1 > person2) {
                int temp = person1;
                person1 = person2;
                person2 = temp;
            }
            int group1 = personGroupMap.get(person1), group2 = personGroupMap.get(person2);
            if (group1 != group2) {
                Set<Integer> set1 = groupSetMap.get(group1);
                Set<Integer> set2 = groupSetMap.get(group2);
                if (group1 < group2) {
                    set1.addAll(set2);
                    for (int person : set1)
                        personGroupMap.put(person, group1);
                    groupSetMap.put(group1, set1);
                    groupSetMap.remove(group2);
                } else {
                    set2.addAll(set1);
                    for (int person : set2)
                        personGroupMap.put(person, group2);
                    groupSetMap.put(group2, set2);
                    groupSetMap.remove(group1);
                }
                if (groupSetMap.size() == 1)
                    return timestamp;
            }
        }
        return -1;
    }
}