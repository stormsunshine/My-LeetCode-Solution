class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] degrees = new int[N];
        Map<Integer, Set<Integer>> dislikesMap = new HashMap<Integer, Set<Integer>>();
        for (int[] dislike : dislikes) {
            int person1 = dislike[0] - 1, person2 = dislike[1] - 1;
            degrees[person1]++;
            degrees[person2]++;
            Set<Integer> dislikesSet1 = dislikesMap.getOrDefault(person1, new HashSet<Integer>());
            Set<Integer> dislikesSet2 = dislikesMap.getOrDefault(person2, new HashSet<Integer>());
            dislikesSet1.add(person2);
            dislikesSet2.add(person1);
            dislikesMap.put(person1, dislikesSet1);
            dislikesMap.put(person2, dislikesSet2);
        }
        int[] groups = new int[N];
        for (int i = 0; i < N; i++) {
            if (degrees[i] > 0 && groups[i] == 0) {
                groups[i] = 1;
                boolean possible = breadthFirstSearch(dislikesMap, groups, i);
                if (!possible)
                    return false;
            }
        }
        return true;
    }

    public boolean breadthFirstSearch(Map<Integer, Set<Integer>> dislikesMap, int[] groups, int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int person = queue.poll();
            int group = groups[person];
            int newGroup = 3 - group;
            Set<Integer> dislikes = dislikesMap.getOrDefault(person, new HashSet<Integer>());
            for (int dislike : dislikes) {
                if (groups[dislike] == group)
                    return false;
                else if (groups[dislike] == 0) {
                    groups[dislike] = newGroup;
                    queue.offer(dislike);
                }
            }
        }
        return true;
    }
}