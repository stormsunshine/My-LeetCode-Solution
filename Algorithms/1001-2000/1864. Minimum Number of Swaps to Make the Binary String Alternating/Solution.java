class Solution {
    public int minSwaps(String s) {
        int length = s.length();
        int zeros = 0, ones = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0')
                zeros++;
            else
                ones++;
        }
        if (Math.abs(zeros - ones) > 1)
            return -1;
        if (length % 2 == 0) {
            int swap0 = 0, swap1 = 0;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (i % 2 == 0) {
                    if (c == '1')
                        swap0++;
                    else
                        swap1++;
                } else {
                    if (c == '0')
                        swap0++;
                    else
                        swap1++;
                }
            }
            return Math.min(swap0, swap1) / 2;
        } else {
            int swap = 0;
            if (zeros > ones) {
                for (int i = 0; i < length; i++) {
                    char c = s.charAt(i);
                    if (i % 2 == 0) {
                        if (c == '1')
                            swap++;
                    } else {
                        if (c == '0')
                            swap++;
                    }
                }
            } else {
                for (int i = 0; i < length; i++) {
                    char c = s.charAt(i);
                    if (i % 2 == 0) {
                        if (c == '0')
                            swap++;
                    } else {
                        if (c == '1')
                            swap++;
                    }
                }
            }
            return swap / 2;
        }
    }
}