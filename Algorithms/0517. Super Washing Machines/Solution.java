class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int num : machines)
            sum += num;
        int length = machines.length;
        if (sum % length != 0)
            return -1;
        int mean = sum / length;
        int[] differences = new int[length];
        for (int i = 0; i < length; i++)
            differences[i] = machines[i] - mean;
        int moves = 0;
        int prefixSum = 0, max = 0;
        for (int i = 0; i < length; i++) {
            int difference = differences[i];
            prefixSum += difference;
            max = Math.max(max, Math.abs(prefixSum));
            moves = Math.max(moves, Math.max(max, difference));
        }
        return moves;
    }
}