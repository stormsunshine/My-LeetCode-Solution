class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] server1, int[] server2) {
                if (server1[0] != server2[0])
                    return server1[0] - server2[0];
                else
                    return server1[1] - server2[1];
            }
        });
        for (int i = 0; i < n; i++)
            priorityQueue.offer(new int[]{servers[i], i});
        PriorityQueue<int[]> waiting = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] server1, int[] server2) {
                if (server1[0] != server2[0])
                    return server1[0] - server2[0];
                else if (server1[1] != server2[1])
                    return server1[1] - server2[1];
                else
                    return server1[2] - server2[2];
            }
        });
        int curTime = 0;
        for (int i = 0; i < m; i++) {
            curTime = Math.max(curTime, i);
            while (!waiting.isEmpty() && waiting.peek()[0] <= curTime) {
                int[] next = waiting.poll();
                priorityQueue.offer(new int[]{servers[next[2]], next[2]});
            }
            if (priorityQueue.isEmpty()) {
                int[] next = waiting.poll();
                curTime = next[0];
                priorityQueue.offer(new int[]{servers[next[2]], next[2]});
            }
            int task = tasks[i];
            int[] server = priorityQueue.poll();
            waiting.offer(new int[]{curTime + task, server[0], server[1]});
            ans[i] = server[1];
        }
        return ans;
    }
}