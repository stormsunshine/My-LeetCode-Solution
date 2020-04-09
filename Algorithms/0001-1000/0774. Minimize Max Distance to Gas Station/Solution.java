class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        int length = stations.length;
        double low = 0, high = stations[length - 1] - stations[0];
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            int minStations = 0;
            for (int i = 1; i < length; i++)
                minStations += (int) ((stations[i] - stations[i - 1]) / mid);
            if (minStations <= K)
                high = mid;
            else
                low = mid;
        }
        return low;
    }
}