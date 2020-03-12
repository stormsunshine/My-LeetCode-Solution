class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] bits = new int[32];
        int length = nums.length;
        for (int num : nums) {
            int remaining = num;
            int index = 31;
            while (remaining > 0) {
                bits[index] += remaining & 1;
                remaining >>>= 1;
                index--;
            }
        }
        int totalDistance = 0;
        for (int i = 0; i < 32; i++) {
            int curOnes = bits[i];
            totalDistance += curOnes * (length - curOnes);
        }
        return totalDistance;
    }
}