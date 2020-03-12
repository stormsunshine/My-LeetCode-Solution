class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> curCombination = new ArrayList<Integer>();
        findCombinations3(combinations, curCombination, 1, k, n);
        return combinations;
    }

    public void findCombinations3(List<List<Integer>> combinations, List<Integer> curCombination, int startNum, int k, int n) {
        if (k == 0) {
            if (n == 0)
                combinations.add(new ArrayList<Integer>(curCombination));
        } else if (k > 0 && n > 0) {
            for (int i = startNum; i <= 9; i++) {
                if (i > n)
                    break;
                else {
                    curCombination.add(i);
                    findCombinations3(combinations, curCombination, i + 1, k - 1, n - i);
                    curCombination.remove(curCombination.size() - 1);
                }
            }
        }
    }
}