class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < n; i++) {
            int curManager = manager[i];
            if (curManager >= 0) {
                Set<Integer> set = map.getOrDefault(curManager, new HashSet<Integer>());
                set.add(i);
                map.put(curManager, set);
            }
        }
        int minutes = 0;
        Queue<Integer> employeeQueue = new LinkedList<Integer>();
        Queue<Integer> timeQueue = new LinkedList<Integer>();
        employeeQueue.offer(headID);
        timeQueue.offer(0);
        while (!employeeQueue.isEmpty()) {
            int employee = employeeQueue.poll();
            int time = timeQueue.poll();
            minutes = Math.max(minutes, time);
            int totalTime = time + informTime[employee];
            Set<Integer> subordinates = map.getOrDefault(employee, new HashSet<Integer>());
            for (int subordinate : subordinates) {
                employeeQueue.offer(subordinate);
                timeQueue.offer(totalTime);
            }
        }
        return minutes;
    }
}