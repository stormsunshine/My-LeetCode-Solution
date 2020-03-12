class Solution {
    public int kthGrammar(int N, int K) {
        int reverseCount = 0;
        while (K > 1) {
            int log = (int) Math.ceil(Math.log(K) / Math.log(2));
            int power2 = (int) Math.pow(2, log);
            K = power2 + 1 - K;
            if (log % 2 == 1)
                reverseCount++;
        }
        return reverseCount % 2;
    }
}