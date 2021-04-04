class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] answer = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            Set<Integer> set = map.getOrDefault(id, new HashSet<Integer>());
            set.add(time);
            map.put(id, set);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            answer[size - 1]++;
        }
        return answer;
    }
}