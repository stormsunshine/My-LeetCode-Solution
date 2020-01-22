class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        Map<Integer, List<Integer>> obstaclesEachX = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> obstaclesEachY = new HashMap<Integer, List<Integer>>();
        for (int[] obstacle : obstacles) {
            int obstacleX = obstacle[0], obstacleY = obstacle[1];
            List<Integer> obstaclesX = obstaclesEachX.getOrDefault(obstacleX, new ArrayList<Integer>());
            obstaclesX.add(obstacleY);
            obstaclesEachX.put(obstacleX, obstaclesX);
            List<Integer> obstaclesY = obstaclesEachY.getOrDefault(obstacleY, new ArrayList<Integer>());
            obstaclesY.add(obstacleX);
            obstaclesEachY.put(obstacleY, obstaclesY);
        }
        int positionX = 0, positionY = 0;
        int maxDistance = 0;
        int length = commands.length;
        for (int i = 0; i < length; i++) {
            int command = commands[i];
            if (command < 0) {
                if (command == -1)
                    directionIndex = directionIndex == 3 ? 0 : directionIndex + 1;
                else if (command == -2)
                    directionIndex = directionIndex == 0 ? 3 : directionIndex - 1;
            } else {
                int[] direction = directions[directionIndex];
                if (directionIndex % 2 == 0) {
                    List<Integer> obstaclesList = obstaclesEachX.getOrDefault(positionX, new ArrayList<Integer>());
                    for (int j = 1; j <= command; j++) {
                        int nextY = positionY + direction[1];
                        if (obstaclesList.contains(nextY))
                            break;
                        else {
                            positionY = nextY;
                            maxDistance = Math.max(maxDistance, positionX * positionX + positionY * positionY);
                        }
                    }
                } else {
                    List<Integer> obstaclesList = obstaclesEachY.getOrDefault(positionY, new ArrayList<Integer>());
                    for (int j = 1; j <= command; j++) {
                        int nextX = positionX + direction[0];
                        if (obstaclesList.contains(nextX))
                            break;
                        else {
                            positionX = nextX;
                            maxDistance = Math.max(maxDistance, positionX * positionX + positionY * positionY);
                        }
                    }
                }
            }
        }
        return maxDistance;
    }
}