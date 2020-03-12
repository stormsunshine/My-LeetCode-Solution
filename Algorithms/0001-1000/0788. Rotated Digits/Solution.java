class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            String numStr = String.valueOf(i);
            if (numStr.indexOf('3') >= 0 || numStr.indexOf('4') >= 0 || numStr.indexOf('7') >= 0)
                continue;
            if (numStr.indexOf('2') >= 0 || numStr.indexOf('5') >= 0 || numStr.indexOf('6') >= 0 || numStr.indexOf('9') >= 0)
                count++;
        }
        return count;
    }
}