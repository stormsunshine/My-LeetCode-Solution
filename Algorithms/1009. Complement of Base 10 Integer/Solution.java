class Solution {
    public int bitwiseComplement(int N) {
        if (N <= 1)
            return 1 - N;
        int power = (int) (Math.log(N) / Math.log(2));
        int max = (int) (Math.pow(2, power + 1) - 1);
        return max - N;
    }
}