class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int length = values.length;
        int[][] valuesLabels = new int[length][2];
        for (int i = 0; i < length; i++) {
            valuesLabels[i][0] = values[i];
            valuesLabels[i][1] = labels[i];
        }
        Arrays.sort(valuesLabels, new Comparator<int[]>() {
            public int compare(int[] valueLabel1, int[] valueLabel2) {
                if (valueLabel1[0] != valueLabel2[0])
                    return valueLabel2[0] - valueLabel1[0];
                else
                    return valueLabel1[1] - valueLabel2[1];
            }
        });
        Map<Integer, Integer> labelCountMap = new HashMap<Integer, Integer>();
        Set<Integer> labelsLimitSet = new HashSet<Integer>();
        int sum = 0;
        int itemsCount = 0;
        int index = 0;
        while (index < length && itemsCount < num_wanted) {
            int[] valueLabel = valuesLabels[index++];
            int value = valueLabel[0], label = valueLabel[1];
            if (!labelsLimitSet.contains(label)) {
                int labelCount = labelCountMap.getOrDefault(label, 0);
                labelCount++;
                if (labelCount == use_limit) {
                    labelCountMap.remove(label);
                    labelsLimitSet.add(label);
                } else
                    labelCountMap.put(label, labelCount);
                sum += value;
                itemsCount++;
            }
        }
        return sum;
    }
}