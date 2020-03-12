class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] differences = new int[length];
        int sum = 0;
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            int difference = gas[i] - cost[i];
            differences[i] = difference;
            sum += difference;
            if (difference >= 0)
                candidates.add(i);
        }
        if (sum < 0)
            return -1;
        int size = candidates.size();
        for (int startIndex : candidates) {
            int index = startIndex;
            int accumulateSum = 0;
            for (int i = 0; i < length; i++) {
                accumulateSum += differences[index];
                if (accumulateSum < 0)
                    break;
                index = (index + 1) % length;
            }
            if (accumulateSum >= 0)
                return startIndex;
        }
        return -1;
    }
}