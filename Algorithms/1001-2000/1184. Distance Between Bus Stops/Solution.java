class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalDistance = 0;
        for (int num : distance)
            totalDistance += num;
        int min = Math.min(start, destination), max = Math.max(start, destination);
        int distance1 = 0;
        for (int i = min; i < max; i++)
            distance1 += distance[i];
        int distance2 = totalDistance - distance1;
        return Math.min(distance1, distance2);
    }
}