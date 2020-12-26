class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = customers[0][1];
        int prev = customers[0][0] + customers[0][1];
        int length = customers.length;
        for (int i = 1; i < length; i++) {
            int[] customer = customers[i];
            int arrival = customer[0], time = customer[1];
            if (arrival >= prev) {
                total += time;
                prev = arrival + time;
            } else {
                int end = prev + time;
                total += end - arrival;
                prev += time;
            }
        }
        return total / length;
    }
}