class Solution {
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++)
            array[i] = nums[i];
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (Math.abs(num1) != Math.abs(num2))
                    return Math.abs(num2) - Math.abs(num1);
                else
                    return num2 - num1;
            }
        });
        List<Integer> zeroList = new ArrayList<Integer>();
        List<Integer> positiveList = new ArrayList<Integer>();
        List<Integer> negativeList = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            int num = array[i];
            if (num > 0)
                positiveList.add(num);
            else if (num < 0)
                negativeList.add(num);
            else
                zeroList.add(num);
        }
        int zeroCount = zeroList.size(), positiveCount = positiveList.size(), negativeCount = negativeList.size();
        if (negativeCount == 0) {
            if (positiveCount >= 3)
                return positiveList.get(0) * positiveList.get(1) * positiveList.get(2);
            else
                return 0;
        } else if (negativeCount == 1) {
            if (positiveCount >= 3)
                return positiveList.get(0) * positiveList.get(1) * positiveList.get(2);
            else {
                if (zeroCount > 0)
                    return 0;
                else if (positiveCount >= 2)
                    return positiveList.get(positiveCount - 1) * positiveList.get(positiveCount - 2) * negativeList.get(negativeCount - 1);
                else
                    return 0;
            }
        } else {
            int max = 0;
            if (positiveCount >= 3)
                max = Math.max(max, positiveList.get(0) * positiveList.get(1) * positiveList.get(2));
            if (positiveCount >= 1) {
                max = Math.max(max, positiveList.get(0) * negativeList.get(0) * negativeList.get(1));
            } else {
                if (zeroCount > 0)
                    return 0;
                else
                    return negativeList.get(negativeCount - 1) * negativeList.get(negativeCount - 2) * negativeList.get(negativeCount - 3);
            }
            return max;
        }
    }
}