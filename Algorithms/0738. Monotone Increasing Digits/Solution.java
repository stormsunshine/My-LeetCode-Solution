class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] numArray = String.valueOf(N).toCharArray();
        int firstIndex = -1;
        int length = numArray.length;
        for (int i = length - 1; i > 0; i--) {
            if (numArray[i] < numArray[i - 1]) {
                firstIndex = i - 1;
                numArray[i - 1]--;
            }
        }
        if (firstIndex < 0)
            return N;
        else {
            for (int i = firstIndex + 1; i < length; i++)
                numArray[i] = '9';
        }
        String numStr = new String(numArray);
        return Integer.parseInt(numStr);
    }
}