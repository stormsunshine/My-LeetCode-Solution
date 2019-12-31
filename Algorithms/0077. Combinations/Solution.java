class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (n < k)
            return combinations;
        List<Integer> combination = new ArrayList<Integer>();
        for (int i = 1; i <= k; i++)
            combination.add(i);
        while (combination.size() > 0) {
            combinations.add(combination);
            combination = nextCombination(combination, n, k);
        }
        return combinations;
    }

    public List<Integer> nextCombination(List<Integer> combination, int n, int k) {
        List<Integer> nextCombination = new ArrayList<Integer>();
        int lastNum = combination.get(k - 1);
        if (lastNum < n) {
            for (int i = 0; i < k - 1; i++)
                nextCombination.add(combination.get(i));
            nextCombination.add(lastNum + 1);
        } else {
            int changeIndex = -1;
            for (int i = k - 2; i >= 0; i--) {
                if (combination.get(i + 1) - combination.get(i) > 1) {
                    changeIndex = i;
                    break;
                }
            }
            if (changeIndex >= 0) {
                for (int i = 0; i < changeIndex; i++)
                    nextCombination.add(combination.get(i));
                int changeNum = combination.get(changeIndex) + 1;
                for (int i = changeIndex, num = changeNum; i < k; i++, num++)
                    nextCombination.add(num);
            }
        }
        return nextCombination;
    }
}