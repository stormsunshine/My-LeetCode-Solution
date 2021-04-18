class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        long[][] newTasks = new long[n][3];
        for (int i = 0; i < n; i++) {
            newTasks[i][0] = (long) tasks[i][0];
            newTasks[i][1] = (long) tasks[i][1];
            newTasks[i][2] = (long) i;
        }
        Arrays.sort(newTasks, new Comparator<long[]>() {
            public int compare(long[] task1, long[] task2) {
                if (task1[0] == task2[0])
                    return 0;
                else if (task1[0] > task2[0])
                    return 1;
                else
                    return -1;
            }
        });
        int[] order = new int[n];
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<long[]>(new Comparator<long[]>() {
            public int compare(long[] task1, long[] task2) {
                if (task1[1] != task2[1])
                    return task1[1] > task2[1] ? 1 : -1;
                else
                    return task1[2] > task2[2] ? 1 : -1;
            }
        });
        int index = 0, orderIndex = 0;
        long curTime = newTasks[index][0];
        while (index < n) {
            long[] task = newTasks[index];
            if (task[0] <= curTime || priorityQueue.isEmpty()) {
                priorityQueue.offer(task);
                curTime = Math.max(curTime, task[0]);
                index++;
            } else {
                long[] nextTask = priorityQueue.poll();
                order[orderIndex++] = (int) nextTask[2];
                curTime = Math.max(curTime + nextTask[1], nextTask[0] + nextTask[1]);
            }
        }
        while (!priorityQueue.isEmpty()) {
            long[] nextTask = priorityQueue.poll();
            order[orderIndex++] = (int) nextTask[2];
            curTime = Math.max(curTime + nextTask[1], nextTask[0] + nextTask[1]);
        }
        return order;
    }
}