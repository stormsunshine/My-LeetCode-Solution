class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] bestCoordinate = {0, 0};
        int maxQuality = 0;
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int[] coordinate = {x, y};
                int quality = 0;
                for (int[] tower : towers) {
                    double distance = getDistance(coordinate, tower);
                    if (distance <= radius)
                        quality += (int) Math.floor(tower[2] / (1 + distance));
                }
                if (quality > maxQuality) {
                    bestCoordinate = coordinate;
                    maxQuality = quality;
                }
            }
        }
        return bestCoordinate;
    }

    public double getDistance(int[] coordinate, int[] tower) {
        return Math.sqrt((tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]));
    }
}