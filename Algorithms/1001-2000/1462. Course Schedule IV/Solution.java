class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> prerequisiteMap = new HashMap<Integer, Set<Integer>>();
        for (int[] prerequisite : prerequisites) {
            int course0 = prerequisite[0], course1 = prerequisite[1];
            Set<Integer> set = prerequisiteMap.getOrDefault(course0, new HashSet<Integer>());
            set.add(course1);
            prerequisiteMap.put(course0, set);
        }
        List<Boolean> checkList = new ArrayList<Boolean>();
        Map<Integer, Boolean> queryMap = new HashMap<Integer, Boolean>();
        int queriesCount = queries.length;
        for (int i = 0; i < queriesCount; i++) {
            int[] query = queries[i];
            boolean isPrerequisite = search(prerequisiteMap, queryMap, query[0], query[1], n);
            checkList.add(isPrerequisite);
        }
        return checkList;
    }

    public boolean search(Map<Integer, Set<Integer>> prerequisiteMap, Map<Integer, Boolean> queryMap, int course0, int course1, int n) {
        int key = course0 * n + course1;
        if (queryMap.containsKey(key))
            return queryMap.get(key);
        Set<Integer> set = prerequisiteMap.getOrDefault(course0, new HashSet<Integer>());
        if (set.contains(course1)) {
            queryMap.put(key, true);
            return true;
        } else {
            for (int nextCourse : set) {
                if (search(prerequisiteMap, queryMap, nextCourse, course1, n)) {
                    queryMap.put(key, true);
                    return true;
                }
            }
        }
        queryMap.put(key, false);
        return false;
    }
}