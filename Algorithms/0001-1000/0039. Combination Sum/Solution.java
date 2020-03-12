class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> curCombination = new ArrayList<Integer>();
        findCombinations(combinations, curCombination, 0, candidates, target);
        return combinations;
    }

    public void findCombinations(List<List<Integer>> combinations, List<Integer> curCombination, int startIndex, int[] candidates, int target) {
        if (target > 0) {
            int length = candidates.length;
            for (int i = startIndex; i < length; i++) {
                int num = candidates[i];
                if (num > target)
                    break;
                else {
                    curCombination.add(num);
                    findCombinations(combinations, curCombination, i, candidates, target - num);
                    curCombination.remove(curCombination.size() - 1);
                }
            }
        } else {
            if (target == 0)
                combinations.add(new ArrayList<Integer>(curCombination));
        }
    }
}