class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MODULO = 1000000007;
        TreeMap<Integer, Integer> buyMap = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> sellMap = new TreeMap<Integer, Integer>();
        int length = orders.length;
        for (int i = 0; i < length; i++) {
            int[] order = orders[i];
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {
                while (amount > 0 && sellMap.size() > 0 && sellMap.firstKey() <= price) {
                    Integer key = sellMap.firstKey();
                    int sellAmount = sellMap.get(key);
                    if (sellAmount <= amount) {
                        amount -= sellAmount;
                        sellMap.remove(key);
                    } else {
                        sellMap.put(key, sellAmount - amount);
                        amount = 0;
                    }
                }
                if (amount > 0)
                    buyMap.put(price, buyMap.getOrDefault(price, 0) + amount);
            } else {
                while (amount > 0 && buyMap.size() > 0 && buyMap.lastKey() >= price) {
                    Integer key = buyMap.lastKey();
                    int buyAmount = buyMap.get(key);
                    if (buyAmount <= amount) {
                        amount -= buyAmount;
                        buyMap.remove(key);
                    } else {
                        buyMap.put(key, buyAmount - amount);
                        amount = 0;
                    }
                }
                if (amount > 0)
                    sellMap.put(price, sellMap.getOrDefault(price, 0) + amount);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : buyMap.entrySet())
            count = (count + entry.getValue()) % MODULO;
        for (Map.Entry<Integer, Integer> entry : sellMap.entrySet())
            count = (count + entry.getValue()) % MODULO;
        return count;
    }
}