class SnakeGame {
    int width;
    int height;
    int[][] food;
    int foodCount;
    int foodIndex;
    Queue<int[]> positionQueue;
    Queue<String> positionStringQueue;
    int[] curPosition;
    int score;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodCount = food.length;
        foodIndex = 0;
        positionQueue = new LinkedList<int[]>();
        positionStringQueue = new LinkedList<String>();
        curPosition = new int[]{0, 0};
        positionQueue.offer(curPosition);
        positionStringQueue.offer(Arrays.toString(curPosition));
        score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        String directions = "ULRD";
        int directionIndex = directions.indexOf(direction);
        if (directionIndex < 0)
            return -1;
        int[][] directionsArray = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int[] directionArray = directionsArray[directionIndex];
        int[] newPosition = {curPosition[0] + directionArray[0], curPosition[1] + directionArray[1]};
        if (newPosition[0] < 0 || newPosition[0] >= height || newPosition[1] < 0 || newPosition[1] >= width)
            return -1;
        if (foodIndex < foodCount) {
            int[] curFood = food[foodIndex];
            if (newPosition[0] == curFood[0] && newPosition[1] == curFood[1]) {
                foodIndex++;
                positionQueue.offer(newPosition);
                positionStringQueue.offer(Arrays.toString(newPosition));
                curPosition[0] = newPosition[0];
                curPosition[1] = newPosition[1];
                score++;
                return score;
            }
        }
        positionQueue.poll();
        positionStringQueue.poll();
        if (positionStringQueue.contains(Arrays.toString(newPosition)))
            return -1;
        positionQueue.offer(newPosition);
        positionStringQueue.offer(Arrays.toString(newPosition));
        curPosition[0] = newPosition[0];
        curPosition[1] = newPosition[1];
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */