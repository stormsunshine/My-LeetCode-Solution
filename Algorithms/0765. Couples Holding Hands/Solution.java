class Solution {
    public int minSwapsCouples(int[] row) {
        int swaps = 0;
        Map<Integer, Integer> numberIndexMap = new HashMap<Integer, Integer>();
        int length = row.length;
        for (int i = 0; i < length; i++)
            numberIndexMap.put(row[i], i);
        for (int i = 0; i < length; i += 2) {
            int num1 = row[i];
            int couple = getCouple(num1);
            int coupleIndex = numberIndexMap.get(couple);
            if (coupleIndex != i + 1) {
                int num2 = row[i + 1];
                row[i + 1] = couple;
                row[coupleIndex] = num2;
                numberIndexMap.put(couple, i + 1);
                numberIndexMap.put(num2, coupleIndex);
                swaps++;
            }
        }
        return swaps;
    }

    public int getCouple(int num) {
        return num % 2 == 0 ? num + 1 : num - 1;
    }
}