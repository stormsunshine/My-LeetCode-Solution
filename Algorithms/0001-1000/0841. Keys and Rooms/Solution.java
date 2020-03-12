class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length = rooms.size();
        boolean[] visited = new boolean[length];
        int visitCount = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            if (!visited[room]) {
                visited[room] = true;
                visitCount++;
                List<Integer> keys = rooms.get(room);
                for (int key : keys) {
                    if (!visited[key])
                        queue.offer(key);
                }
            }
        }
        return visitCount == length;
    }
}