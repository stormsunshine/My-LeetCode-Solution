class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] course1, int[] course2) {
                if (course1[1] != course2[1])
                    return course1[1] - course2[1];
                else
                    return course1[0] - course2[0];
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        int courseCount = 0;
        int day = 0;
        int length = courses.length;
        for (int i = 0; i < length; i++) {
            int[] course = courses[i];
            int duration = course[0], end = course[1];
            if (day + duration <= end) {
                priorityQueue.offer(duration);
                day += duration;
                courseCount++;
            } else if (!priorityQueue.isEmpty() && priorityQueue.peek() > duration) {
                int prevDuration = priorityQueue.poll();
                priorityQueue.offer(duration);
                day -= prevDuration;
                day += duration;
            }
        }
        return courseCount;
    }
}