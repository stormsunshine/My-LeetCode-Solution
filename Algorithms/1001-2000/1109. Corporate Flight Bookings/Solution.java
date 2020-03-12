class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0], end = booking[1], count = booking[2];
            seats[start - 1] += count;
            if (end < n)
                seats[end] -= count;
        }
        for (int i = 1; i < n; i++)
            seats[i] += seats[i - 1];
        return seats;
    }
}