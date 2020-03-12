class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int index = 0;
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites)
            inDegrees[prerequisite[0]]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int prerequisiteCourse = queue.poll();
            order[index] = prerequisiteCourse;
            index++;
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
        if (index != numCourses)
            return new int[0];
        return order;
    }
}