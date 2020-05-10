class Solution {
    public int countTriplets(int[] arr) {
        int length = arr.length;
        int[] leftXOR = new int[length];
        leftXOR[0] = arr[0];
        for (int i = 1; i < length; i++)
            leftXOR[i] = leftXOR[i - 1] ^ arr[i];
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int xor1 = i == 0 ? leftXOR[j - 1] : leftXOR[j - 1] ^ leftXOR[i - 1];
                for (int k = j; k < length; k++) {
                    int xor2 = leftXOR[k] ^ leftXOR[j - 1];
                    if (xor1 == xor2)
                        count++;
                }
            }
        }
        return count;
    }
}