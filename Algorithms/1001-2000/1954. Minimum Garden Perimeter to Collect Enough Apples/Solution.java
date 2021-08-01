class Solution {
    public long minimumPerimeter(long neededApples) {
        long low = 2, high = Math.min(neededApples, 1000000);
        if (high % 2 == 1)
            high--;
        while (low < high) {
            long mid = (high - low) / 2 + low;
            if (mid % 2 == 1)
                mid--;
            long apples = countApples(mid);
            if (apples < neededApples)
                low = mid + 2;
            else
                high = mid;
        }
        return low * 4;
    }

    public long countApples(long side) {
        long center = side / 2 * (side / 2 + 1);
        long start = center + side + 1;
        long end = center + (side + 1) * side / 2;
        long total = (start + end) * side / 2 + center;
        return total;
    }
}