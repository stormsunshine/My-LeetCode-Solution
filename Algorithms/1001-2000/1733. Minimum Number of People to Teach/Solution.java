class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> languagesMap = new HashMap<Integer, Set<Integer>>();
        int m = languages.length;
        for (int i = 0; i < m; i++) {
            int index = i + 1;
            int[] language = languages[i];
            Set<Integer> set = new HashSet<Integer>();
            for (int num : language)
                set.add(num);
            languagesMap.put(index, set);
        }
        List<int[]> friendshipsList = new ArrayList<int[]>();
        int pairs = friendships.length;
        for (int i = 0; i < pairs; i++) {
            int[] friendship = friendships[i];
            int user1 = friendship[0], user2 = friendship[1];
            Set<Integer> set1 = new HashSet<Integer>(languagesMap.getOrDefault(user1, new HashSet<Integer>()));
            Set<Integer> set2 = new HashSet<Integer>(languagesMap.getOrDefault(user2, new HashSet<Integer>()));
            set1.retainAll(set2);
            if (set1.size() == 0)
                friendshipsList.add(friendship);
        }
        Set<Integer> candidates = new HashSet<Integer>();
        Set<Integer> usersSet = new HashSet<Integer>();
        for (int[] friendship : friendshipsList) {
            int user1 = friendship[0], user2 = friendship[1];
            Set<Integer> set1 = languagesMap.getOrDefault(user1, new HashSet<Integer>());
            Set<Integer> set2 = languagesMap.getOrDefault(user2, new HashSet<Integer>());
            candidates.addAll(set1);
            candidates.addAll(set2);
            usersSet.add(user1);
            usersSet.add(user2);
        }
        if (candidates.isEmpty())
            return 0;
        int minTeach = Integer.MAX_VALUE;
        for (int candidate : candidates) {
            int teach = 0;
            for (int user : usersSet) {
                if (!languagesMap.getOrDefault(user, new HashSet<Integer>()).contains(candidate))
                    teach++;
            }
            minTeach = Math.min(minTeach, teach);
        }
        return minTeach;
    }
}