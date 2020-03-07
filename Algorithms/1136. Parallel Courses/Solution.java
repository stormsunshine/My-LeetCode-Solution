class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> relationsMap = new HashMap<Integer, List<Integer>>();
        int[] indegrees = new int[N];
        for (int[] relation : relations) {
            int before = relation[0] - 1, after = relation[1] - 1;
            List<Integer> list = relationsMap.getOrDefault(before, new ArrayList<Integer>());
            list.add(after);
            relationsMap.put(before, list);
            indegrees[after]++;
        }
        int remain = N;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            if (indegrees[i] == 0) {
                remain--;
                queue.offer(i);
            }
        }
        int semesters = 0;
        while (!queue.isEmpty()) {
            semesters++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                List<Integer> nextCourses = relationsMap.getOrDefault(course, new ArrayList<Integer>());
                for (int nextCourse : nextCourses) {
                    indegrees[nextCourse]--;
                    if (indegrees[nextCourse] == 0) {
                        remain--;
                        queue.offer(nextCourse);
                    }
                }
            }
        }
        if (remain > 0)
            return -1;
        else
            return semesters;
    }
}