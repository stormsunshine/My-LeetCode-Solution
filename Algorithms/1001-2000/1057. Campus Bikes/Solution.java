class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int workersLength = workers.length, bikesLength = bikes.length;
        int[][] distances = new int[workersLength][bikesLength];
        for (int i = 0; i < workersLength; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikesLength; j++) {
                int[] bike = bikes[j];
                distances[i][j] = manhattanDistance(worker, bike);
            }
        }
        int[] ret = new int[workersLength];
        boolean[] workersAssigned = new boolean[workersLength];
        boolean[] bikesAssigned = new boolean[bikesLength];
        for (int i = 0; i < workersLength; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minWorkerIndex = -1, minBikeIndex = -1;
            for (int j = 0; j < workersLength; j++) {
                if (workersAssigned[j])
                    continue;
                for (int k = 0; k < bikesLength; k++) {
                    if (bikesAssigned[k])
                        continue;
                    int distance = distances[j][k];
                    if (distance < minDistance) {
                        minDistance = distance;
                        minWorkerIndex = j;
                        minBikeIndex = k;
                    }
                }
            }
            ret[minWorkerIndex] = minBikeIndex;
            workersAssigned[minWorkerIndex] = true;
            bikesAssigned[minBikeIndex] = true;
        }
        return ret;
    }

    public int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}