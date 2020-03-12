class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> curCombination = new ArrayList<Integer>();
        findCombinations2(combinations, curCombination, 0, candidates, target);
        return combinations;
    }

    public void findCombinations2(List<List<Integer>> combinations, List<Integer> curCombination, int startIndex, int[] candidates, int target) {
        if (target > 0) {
            int length = candidates.length;
            for (int i = startIndex; i < length; i++) {
                int num = candidates[i];
                if (num > target)
                    break;
                else {
                    curCombination.add(num);
                    findCombinations2(combinations, curCombination, i + 1, candidates, target - num);
                    curCombination.remove(curCombination.size() - 1);
                    while (i < length - 1 && candidates[i] == candidates[i + 1])
                        i++;
                }
            }
        } else {
            if (target == 0)
                combinations.add(new ArrayList<Integer>(curCombination));
        }
    }
}