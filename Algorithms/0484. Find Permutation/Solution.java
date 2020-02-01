class Solution {
    public int[] findPermutation(String s) {
        int length = s.length();
        int[] permutation = new int[length + 1];
        int curNum = 1;
        int startIndex = 0;
        int decreaseCount = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'D')
                decreaseCount++;
            else {
                if (decreaseCount == 0) {
                    permutation[i] = curNum;
                    curNum++;
                    startIndex++;
                } else {
                    int num = curNum + decreaseCount;
                    curNum = num + 1;
                    for (int j = startIndex; j <= i; j++) {
                        permutation[j] = num;
                        num--;
                    }
                    startIndex = i + 1;
                    decreaseCount = 0;
                }
            }
        }
        if (decreaseCount == 0)
            permutation[length] = curNum;
        else {
            int num = curNum + decreaseCount;
            curNum = num + 1;
            for (int i = startIndex; i <= length; i++) {
                permutation[i] = num;
                num--;
            }
        }
        return permutation;
    }
}