class Solution {
    public int missingNumber(int[] arr) {
        int length = arr.length;
        int prevDif = arr[1] - arr[0];
        for (int i = 2; i < length; i++) {
            int curDif = arr[i] - arr[i - 1];
            if (Math.abs(curDif) < Math.abs(prevDif))
                return arr[i - 1] - curDif;
            else if (Math.abs(curDif) > Math.abs(prevDif))
                return arr[i - 1] + prevDif;
            prevDif = curDif;
        }
        return arr[length - 1] + prevDif;
    }
}