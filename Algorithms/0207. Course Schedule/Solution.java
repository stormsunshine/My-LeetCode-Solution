class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites)
            inDegrees[prerequisite[0]]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0)
                queue.offer(i);
        }
        int remainCourses = numCourses;
        while (!queue.isEmpty()) {
            int prerequisiteCourse = queue.poll();
            remainCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == prerequisiteCourse) {
                    int nextCourse = prerequisite[0];
                    if (inDegrees[nextCourse] > 0) {
                        inDegrees[nextCourse]--;
                        if (inDegrees[nextCourse] == 0)
                            queue.offer(nextCourse);
                    }
                }
            }
        }
        return remainCourses == 0;
    }
}