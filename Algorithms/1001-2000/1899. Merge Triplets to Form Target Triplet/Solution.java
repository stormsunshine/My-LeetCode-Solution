class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] merged = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                merged[0] = Math.max(merged[0], triplet[0]);
                merged[1] = Math.max(merged[1], triplet[1]);
                merged[2] = Math.max(merged[2], triplet[2]);
            }
        }
        return Arrays.equals(merged, target);
    }
}