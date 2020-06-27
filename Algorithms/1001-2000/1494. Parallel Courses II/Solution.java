class Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        Map<Integer, Set<Integer>> nextMap = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> prevMap = new HashMap<Integer, Set<Integer>>();
        for (int[] dependency : dependencies) {
            int course0 = dependency[0] - 1, course1 = dependency[1] - 1;
            Set<Integer> set0 = nextMap.getOrDefault(course0, new HashSet<Integer>());
            Set<Integer> set1 = prevMap.getOrDefault(course1, new HashSet<Integer>());
            set0.add(course1);
            set1.add(course0);
            nextMap.put(course0, set0);
            prevMap.put(course1, set1);
        }
        int[] indegrees = new int[n];
        int[] outdegrees = new int[n];
        Set<Integer> keySet = nextMap.keySet();
        for (int course : keySet) {
            Set<Integer> nextSet = nextMap.getOrDefault(course, new HashSet<Integer>());
            Set<Integer> prevSet = prevMap.getOrDefault(course, new HashSet<Integer>());
            for (int nextCourse : nextSet)
                indegrees[nextCourse]++;
            for (int prevCourse : prevSet)
                outdegrees[prevCourse]++;
        }
        int[] tempIndegrees = new int[n];
        int[] tempOutdegrees = new int[n];
        System.arraycopy(indegrees, 0, tempIndegrees, 0, n);
        System.arraycopy(outdegrees, 0, tempOutdegrees, 0, n);
        int[] startSemesters = new int[n];
        int semesters = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (tempIndegrees[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            semesters++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                startSemesters[course] = semesters;
                Set<Integer> nextSet = nextMap.getOrDefault(course, new HashSet<Integer>());
                for (int nextCourse : nextSet) {
                    tempIndegrees[nextCourse]--;
                    if (tempIndegrees[nextCourse] == 0)
                        queue.offer(nextCourse);
                }
            }
        }
        int[] endSemesters = new int[n];
        for (int i = 0; i < n; i++) {
            if (tempOutdegrees[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                endSemesters[course] = semesters;
                Set<Integer> prevSet = prevMap.getOrDefault(course, new HashSet<Integer>());
                for (int prevCourse : prevSet) {
                    tempOutdegrees[prevCourse]--;
                    if (tempOutdegrees[prevCourse] == 0)
                        queue.offer(prevCourse);
                }
            }
            semesters--;
        }
        int totalSemesters = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer course0, Integer course1) {
                if (startSemesters[course0] != startSemesters[course1])
                    return startSemesters[course0] - startSemesters[course1];
                else
                    return endSemesters[course0] - endSemesters[course1];
            }
        });
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0)
                priorityQueue.offer(i);
        }
        while (!priorityQueue.isEmpty()) {
            totalSemesters++;
            int size = Math.min(priorityQueue.size(), k);
            for (int i = 0; i < size; i++) {
                int course = priorityQueue.poll();
                Set<Integer> nextSet = nextMap.getOrDefault(course, new HashSet<Integer>());
                for (int nextCourse : nextSet) {
                    indegrees[nextCourse]--;
                    if (indegrees[nextCourse] == 0)
                        priorityQueue.offer(nextCourse);
                }
            }
        }
        return totalSemesters;
    }
}