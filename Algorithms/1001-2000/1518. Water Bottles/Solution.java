class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int water = numBottles, empty = 0;
        while (water > 0) {
            total += water;
            empty += water;
            water = 0;
            int exchange = empty / numExchange;
            water += exchange;
            empty -= numExchange * exchange;
        }
        return total;
    }
}