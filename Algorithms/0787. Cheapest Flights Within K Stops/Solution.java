class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = Integer.MAX_VALUE;
        prices[src] = 0;
        Map<Integer, List<int[]>> flightsMap = new HashMap<Integer, List<int[]>>();
        for (int[] flight : flights) {
            int flightSrc = flight[0], flightDst = flight[1], flightPrice = flight[2];
            List<int[]> flightsList = flightsMap.getOrDefault(flightSrc, new ArrayList<int[]>());
            flightsList.add(new int[]{flightDst, flightPrice});
            flightsMap.put(flightSrc, flightsList);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);
        int remain = K;
        while (remain >= 0 && !queue.isEmpty()) {
            int[] tempPrices = new int[n];
            for (int i = 0; i < n; i++)
                tempPrices[i] = prices[i];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curSrc = queue.poll();
                int curPrice = prices[curSrc];
                List<int[]> curFlightsList = flightsMap.getOrDefault(curSrc, new ArrayList<int[]>());
                for (int[] flight : curFlightsList) {
                    int flightDst = flight[0], flightPrice = flight[1];
                    int newPrice = curPrice + flightPrice;
                    if (newPrice < tempPrices[flightDst]) {
                        tempPrices[flightDst] = newPrice;
                        queue.offer(flightDst);
                    }
                }
            }
            for (int i = 0; i < n; i++)
                prices[i] = tempPrices[i];
            remain--;
        }
        int totalPrice = prices[dst];
        return totalPrice == Integer.MAX_VALUE ? -1 : totalPrice;
    }
}