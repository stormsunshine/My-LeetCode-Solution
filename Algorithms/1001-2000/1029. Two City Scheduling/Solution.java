class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        int sum = 0;
        int[] differences = new int[length];
        for (int i = 0; i < length; i++) {
            sum += costs[i][0];
            differences[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(differences);
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++)
            sum += differences[i];
        return sum;
    }
}