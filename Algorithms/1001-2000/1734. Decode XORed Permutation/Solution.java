class Solution {
    public int[] decode(int[] encoded) {
        int length = encoded.length;
        int n = length + 1;
        int totalXOR = 0;
        for (int i = 1; i <= n; i++)
            totalXOR ^= i;
        int[] decoded = new int[n];
        int evenXOR = 0, oddXOR = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0)
                evenXOR ^= encoded[i];
            else
                oddXOR ^= encoded[i];
        }
        decoded[0] = totalXOR ^ oddXOR;
        decoded[n - 1] = totalXOR ^ evenXOR;
        for (int i = 0; i < length; i++)
            decoded[i + 1] = decoded[i] ^ encoded[i];
        return decoded;
    }
}