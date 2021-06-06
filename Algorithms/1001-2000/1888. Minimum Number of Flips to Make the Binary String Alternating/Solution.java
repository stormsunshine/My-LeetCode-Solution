class Solution {
    public int minFlips(String s) {
        int length = s.length();
        int count0 = 0, count1 = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (i % 2 == 0)
                    count1++;
                else
                    count0++;
            } else {
                if (i % 2 == 0)
                    count0++;
                else
                    count1++;
            }
        }
        if (length % 2 == 0)
            return Math.min(count0, count1);
        int[][] dpForward = new int[length][2];
        if (s.charAt(0) == '0')
            dpForward[0][1] = 1;
        else
            dpForward[0][0] = 1;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                dpForward[i][0] = dpForward[i - 1][1];
                dpForward[i][1] = dpForward[i - 1][0] + 1;
            } else {
                dpForward[i][0] = dpForward[i - 1][1] + 1;
                dpForward[i][1] = dpForward[i - 1][0];
            }
        }
        int[][] dpBackward = new int[length][2];
        if (s.charAt(length - 1) == '0')
            dpBackward[length - 1][1] = 1;
        else
            dpBackward[length - 1][0] = 1;
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dpBackward[i][0] = dpBackward[i + 1][1];
                dpBackward[i][1] = dpBackward[i + 1][0] + 1;
            } else {
                dpBackward[i][0] = dpBackward[i + 1][1] + 1;
                dpBackward[i][1] = dpBackward[i + 1][0];
            }
        }
        int minCount = Math.min(count0, count1);
        for (int i = 1; i < length; i++) {
            int curMin = Math.min(dpForward[i - 1][0] + dpBackward[i][0], dpForward[i - 1][1] + dpBackward[i][1]);
            minCount = Math.min(minCount, curMin);
        }
        return minCount;
    }
}