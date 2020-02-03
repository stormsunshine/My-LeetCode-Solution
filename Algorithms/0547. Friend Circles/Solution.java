class Solution {
    public int findCircleNum(int[][] M) {
        Map<Integer, Set<Integer>> friendsMap = new HashMap<Integer, Set<Integer>>();
        int studentsCount = M.length;
        for (int i = 0; i < studentsCount; i++) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(i);
            friendsMap.put(i, set);
        }
        for (int i = 0; i < studentsCount; i++) {
            for (int j = i + 1; j < studentsCount; j++) {
                if (M[i][j] == 1) {
                    Set<Integer> set1 = friendsMap.getOrDefault(i, new HashSet<Integer>());
                    Set<Integer> set2 = friendsMap.getOrDefault(j, new HashSet<Integer>());
                    Set<Integer> unionSet = new HashSet<Integer>(set1);
                    unionSet.addAll(set2);
                    for (int student : unionSet)
                        friendsMap.put(student, unionSet);
                }
            }
        }
        int circles = 0;
        Set<Integer> totalSet = new HashSet<Integer>();
        for (int i = 0; i < studentsCount; i++) {
            if (!totalSet.contains(i)) {
                Set<Integer> set = friendsMap.getOrDefault(i, new HashSet<Integer>());
                totalSet.addAll(set);
                circles++;
            }
        }
        return circles;
    }
}