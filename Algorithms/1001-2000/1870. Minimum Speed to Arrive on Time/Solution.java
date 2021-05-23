class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int high = 10000000;
        if (!canArrive(dist, hour, high))
            return -1;
        int low = 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (canArrive(dist, hour, mid))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public boolean canArrive(int[] dist, double hour, int speed) {
        double total = 0;
        int length = dist.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1)
                total += 1.0 * dist[i] / speed;
            else {
                int curr = dist[i] / speed;
                if (dist[i] % speed != 0)
                    curr++;
                total += curr;
            }
        }
        return total <= hour;
    }
}