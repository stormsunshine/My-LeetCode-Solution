class Solution {
    public int[] beautifulArray(int N) {
        int log = (int) Math.ceil(Math.log(N) / Math.log(2));
        int power2 = (int) Math.pow(2, log);
        int[] beautifulArrayPower2 = new int[power2];
        beautifulArrayPower2[0] = 1;
        for (int length = 1; length < power2; length *= 2) {
            for (int i = 0; i < length; i++)
                beautifulArrayPower2[i] *= 2;
            for (int i = 0; i < length; i++)
                beautifulArrayPower2[length * 2 - i - 1] = beautifulArrayPower2[i] - 1;
        }
        int[] beautifulArray = new int[N];
        int index = 0;
        for (int i = 0; i < power2; i++) {
            int num = beautifulArrayPower2[i];
            if (num <= N) {
                beautifulArray[index] = num;
                index++;
            }
        }
        return beautifulArray;
    }
}