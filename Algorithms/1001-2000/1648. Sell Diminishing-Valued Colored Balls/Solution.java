class Solution {
    public int maxProfit(int[] inventory, int orders) {
        final int MODULO = 1000000007;
        long profit = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int balls : inventory) {
            int count = map.getOrDefault(balls, 0) + 1;
            map.put(balls, count);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer balls1, Integer balls2) {
                return balls2 - balls1;
            }
        });
        for (int balls : map.keySet())
            priorityQueue.offer(balls);
        while (orders > 0) {
            int maxBalls = priorityQueue.poll();
            int count = map.get(maxBalls);
            if (priorityQueue.isEmpty()) {
                int quotient = orders / count;
                int remainder = orders % count;
                profit += (long) (maxBalls + maxBalls - quotient + 1) * quotient / 2 * count;
                int remainMaxBalls = maxBalls - quotient;
                profit += (long) remainMaxBalls * remainder;
                break;
            } else {
                int max2Balls = priorityQueue.peek();
                long curOrders = (long) (maxBalls - max2Balls) * count;
                if (curOrders <= orders) {
                    profit += (long) (maxBalls + max2Balls + 1) * curOrders / 2;
                    orders -= (int) curOrders;
                    map.put(max2Balls, map.get(max2Balls) + count);
                } else {
                    int quotient = orders / count;
                    int remainder = orders % count;
                    profit += (long) (maxBalls + maxBalls - quotient + 1) * quotient / 2 * count;
                    int remainMaxBalls = maxBalls - quotient;
                    profit += (long) remainMaxBalls * remainder;
                    break;
                }
            }
        }
        return (int) (profit % MODULO);
    }
}