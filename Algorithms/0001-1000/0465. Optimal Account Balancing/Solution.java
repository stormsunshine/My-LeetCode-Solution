class Solution {
    int minTransactions = Integer.MAX_VALUE;

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] transaction : transactions) {
            int person1 = transaction[0], person2 = transaction[1], amount = transaction[2];
            int value1 = map.getOrDefault(person1, 0) - amount;
            int value2 = map.getOrDefault(person2, 0) + amount;
            map.put(person1, value1);
            map.put(person2, value2);
        }
        int groupSize = map.size();
        int[] balances = new int[groupSize];
        Set<Integer> keySet = map.keySet();
        int index = 0;
        for (int key : keySet) {
            int balance = map.get(key);
            balances[index++] = balance;
        }
        backtrack(balances, 0, 0);
        return minTransactions;
    }

    public void backtrack(int[] balances, int start, int count) {
        int length = balances.length;
        while (start < length && balances[start] == 0)
            start++;
        if (start == length)
            minTransactions = Math.min(minTransactions, count);
        else {
            boolean positive = balances[start] > 0;
            for (int i = start + 1; i < length; i++) {
                if ((balances[i] > 0) ^ positive) {
                    balances[i] += balances[start];
                    backtrack(balances, start + 1, count + 1);
                    balances[i] -= balances[start];
                }
            }
        }
    }
}