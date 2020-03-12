class Solution {
    public int[] threeEqualParts(int[] A) {
        int length = A.length;
        if (A[0] == 0) {
            boolean flag = true;
            for (int i = 1; i < length; i++) {
                if (A[i] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return new int[]{0, length - 1};
        }
        int onesCount = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (A[i] == 1) {
                onesCount++;
                map.put(onesCount, i);
            }
        }
        if (onesCount % 3 != 0)
            return new int[]{-1, -1};
        int onesEachPart = onesCount / 3;
        int index1 = map.get(1);
        int index2 = map.get(onesEachPart + 1);
        int index3 = map.get(onesEachPart * 2 + 1);
        while (index3 < length) {
            int num1 = A[index1], num2 = A[index2], num3 = A[index3];
            if (num1 != num2 || num1 != num3)
                return new int[]{-1, -1};
            index1++;
            index2++;
            index3++;
        }
        return new int[]{index1 - 1, index2};
    }
}