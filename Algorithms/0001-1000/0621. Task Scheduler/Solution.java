class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0);
            count++;
            map.put(task, count);
        }
        PriorityQueue<TaskCount> priorityQueue = new PriorityQueue<TaskCount>();
        Set<Character> set = map.keySet();
        for (char task : set) {
            int count = map.getOrDefault(task, 0);
            TaskCount taskCount = new TaskCount(task, count);
            priorityQueue.offer(taskCount);
        }
        int intervals = 0;
        while (!priorityQueue.isEmpty()) {
            int size = priorityQueue.size();
            int curTasks = Math.min(size, n + 1);
            List<TaskCount> curList = new ArrayList<TaskCount>();
            for (int i = 0; i < curTasks; i++) {
                TaskCount taskCount = priorityQueue.poll();
                taskCount.count--;
                if (taskCount.count > 0)
                    curList.add(taskCount);
            }
            intervals += curList.isEmpty() ? curTasks : n + 1;
            for (TaskCount taskCount : curList)
                priorityQueue.offer(taskCount);
        }
        return intervals;
    }
}

class TaskCount implements Comparable<TaskCount> {
    public char task;
    public int count;

    public TaskCount() {
        
    }

    public TaskCount(char task, int count) {
        this.task = task;
        this.count = count;
    }

    public int compareTo(TaskCount taskCount2) {
        if (this.count != taskCount2.count)
            return taskCount2.count - this.count;
        else
            return this.task - taskCount2.task;
    }
}