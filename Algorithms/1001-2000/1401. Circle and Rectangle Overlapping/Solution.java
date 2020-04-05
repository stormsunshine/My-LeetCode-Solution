class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        if (x_center >= x1 && x_center <= x2 && y_center >= y1 && y_center <= y2)
            return true;
        if (x_center >= x1 && x_center <= x2)
            return y_center >= y1 - radius && y_center <= y2 + radius;
        if (y_center >= y1 && y_center <= y2)
            return x_center >= x1 - radius && x_center <= x2 + radius;
        if (x_center < x1 && y_center < y1) {
            int distanceSquare = distanceSquare(x_center, y_center, x1, y1);
            return distanceSquare <= radius * radius;
        } else if (x_center < x1 && y_center > y2) {
            int distanceSquare = distanceSquare(x_center, y_center, x1, y2);
            return distanceSquare <= radius * radius;
        } else if (x_center > x2 && y_center < y1) {
            int distanceSquare = distanceSquare(x_center, y_center, x2, y1);
            return distanceSquare <= radius * radius;
        } else if (x_center > x2 && y_center > y2) {
            int distanceSquare = distanceSquare(x_center, y_center, x2, y2);
            return distanceSquare <= radius * radius;
        } else
            return false;
    }

    public int distanceSquare(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }
}