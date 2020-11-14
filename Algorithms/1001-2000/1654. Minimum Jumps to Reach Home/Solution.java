class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0)
            return 0;
        Set<Integer> forbiddenSet = new HashSet<Integer>();
        for (int num : forbidden)
            forbiddenSet.add(num);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        int jumps = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            jumps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] array = queue.poll();
                int position = array[0], direction = array[1];
                int nextPosition1 = position + a, nextPosition2 = position - b;
                if (nextPosition1 == x)
                    return jumps;
                else if (nextPosition1 <= 40000 && !visited.contains(nextPosition1) && !forbiddenSet.contains(nextPosition1)) {
                    visited.add(nextPosition1);
                    queue.offer(new int[]{nextPosition1, 1});
                }
                if (direction > 0 && nextPosition2 >= 0) {
                    if (nextPosition2 == x)
                        return jumps;
                    else if (!visited.contains(nextPosition2) && !forbiddenSet.contains(nextPosition2)) {
                        visited.add(-nextPosition2);
                        queue.offer(new int[]{nextPosition2, -1});
                    }
                }
            }
        }
        return -1;
    }
}