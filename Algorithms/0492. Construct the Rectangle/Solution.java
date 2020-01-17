class Solution {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        int width = sqrt;
        while (width > 1) {
            if (area % width == 0)
                break;
            width--;
        }
        int length = area / width;
        int[] rectangle = {length, width};
        return rectangle;
    }
}