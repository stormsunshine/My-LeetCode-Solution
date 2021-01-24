class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int altitude = 0;
        int length = gain.length;
        for (int i = 0; i < length; i++) {
            altitude += gain[i];
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }
}