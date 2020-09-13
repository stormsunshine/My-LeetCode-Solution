class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length <= 1)
            return 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array1[2] - array2[2];
            }
        });
        int length = points.length;
        int[][] distances = new int[length][length];
        for (int i = 0; i < length; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < length; j++) {
                int[] point2 = points[j];
                int distance = manhattanDistance(point1, point2);
                priorityQueue.offer(new int[]{i, j, distance});
                distances[i][j] = distance;
                distances[j][i] = distance;
            }
        }
        int[] parents = new int[length];
        for (int i = 0; i < length; i++)
            parents[i] = i;
        int minCost = 0;
        int size = length;
        while (size > 1) {
            int[] array = priorityQueue.poll();
            int index1 = array[0], index2 = array[1], distance = array[2];
            if (find(parents, index1) != find(parents, index2)) {
                union(parents, index1, index2);
                minCost += distance;
                size--;
            }
        }
        return minCost;
    }

    public int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public void union(int[] parents, int index1, int index2) {
        parents[find(parents, index1)] = find(parents, index2);
    }

    public int find(int[] parents, int index) {
        while (parents[index] != index) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }
}