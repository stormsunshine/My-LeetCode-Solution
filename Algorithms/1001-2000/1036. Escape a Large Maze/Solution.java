class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked == null || blocked.length == 0)
            return true;
        final int MAX = 1000000;
        Set<String> blockedSet = new HashSet<String>();
        int blockedSize = blocked.length;
        for (int i = 0; i < blockedSize; i++)
            blockedSet.add(Arrays.toString(blocked[i]));
        int search1 = breadthFirstSearch(MAX, blockedSet, source, target);
        if (search1 == 2)
            return true;
        else if (search1 == 0)
            return false;
        else {
            int search2 = breadthFirstSearch(MAX, blockedSet, target, source);
            return search2 > 0;
        }
    }

    public int breadthFirstSearch(final int MAX, Set<String> blockedSet, int[] source, int[] target) {
        int blockedSize = blockedSet.size();
        int blockedArea = blockedSize * (blockedSize - 1) / 2;
        Set<String> visitedSet = new HashSet<String>();
        visitedSet.add(Arrays.toString(source));
        int visitedCount = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] == target[0] && cell[1] == target[1])
                return 2;
            for (int[] direction : directions) {
                int[] nextCell = {cell[0] + direction[0], cell[1] + direction[1]};
                String nextCellStr = Arrays.toString(nextCell);
                if (nextCell[0] >= 0 && nextCell[0] < MAX && nextCell[1] >= 0 && nextCell[1] < MAX && !blockedSet.contains(nextCellStr)) {
                    if (visitedSet.add(nextCellStr)) {
                        queue.offer(nextCell);
                        visitedCount++;
                        if (visitedCount > blockedArea)
                            return 1;
                    }
                }
            }
        }
        return 0;
    }
}