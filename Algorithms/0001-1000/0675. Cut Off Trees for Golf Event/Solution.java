class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] tree1, int[] tree2) {
                return tree1[2] - tree2[2];
            }
        });
        int rows = forest.size(), columns = forest.get(0).size();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int height = forest.get(i).get(j);
                if (height > 1)
                    priorityQueue.offer(new int[]{i, j, height});
            }
        }
        int steps = 0;
        int row = 0, column = 0;
        while (!priorityQueue.isEmpty()) {
            int[] tree = priorityQueue.poll();
            int distance = breadthFirstSearch(forest, row, column, tree[0], tree[1]);
            if (distance < 0)
                return -1;
            else {
                steps += distance;
                row = tree[0];
                column = tree[1];
            }
        }
        return steps;
    }

    public int breadthFirstSearch(List<List<Integer>> forest, int startRow, int startColumn, int endRow, int endColumn) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = forest.size(), columns = forest.get(0).size();
        boolean[][] visited = new boolean[rows][columns];
        visited[startRow][startColumn] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{startRow, startColumn});
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                if (cell[0] == endRow && cell[1] == endColumn)
                    return distance;
                for (int[] direction : directions) {
                    int newRow = cell[0] + direction[0], newColumn = cell[1] + direction[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && !visited[newRow][newColumn] && forest.get(newRow).get(newColumn) > 0) {
                        visited[newRow][newColumn] = true;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}