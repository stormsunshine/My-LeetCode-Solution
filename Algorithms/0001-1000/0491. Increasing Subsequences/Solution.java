class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> increasingSubsequences = new ArrayList<List<Integer>>();
        Set<String> increasingSubsequencesSet = new HashSet<String>();
        Queue<List<Integer>> subsequencesQueue = new LinkedList<List<Integer>>();
        Queue<Integer> indicesQueue = new LinkedList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] <= nums[j]) {
                    List<Integer> subsequence = new ArrayList<Integer>();
                    subsequence.add(nums[i]);
                    subsequence.add(nums[j]);
                    String subsequenceStr = subsequence.toString();
                    if (increasingSubsequencesSet.add(subsequenceStr))
                        increasingSubsequences.add(subsequence);
                    subsequencesQueue.offer(subsequence);
                    indicesQueue.offer(j);
                }
            }
        }
        while (!subsequencesQueue.isEmpty()) {
            List<Integer> subsequence = subsequencesQueue.poll();
            int index = indicesQueue.poll();
            int prevNum = nums[index];
            for (int i = index + 1; i < length; i++) {
                int num = nums[i];
                if (prevNum <= num) {
                    List<Integer> newSubsequence = new ArrayList<Integer>();
                    newSubsequence.addAll(subsequence);
                    newSubsequence.add(num);
                    String subsequenceStr = newSubsequence.toString();
                    if (increasingSubsequencesSet.add(subsequenceStr))
                        increasingSubsequences.add(newSubsequence);
                    subsequencesQueue.offer(newSubsequence);
                    indicesQueue.offer(i);
                }
            }
        }
        return increasingSubsequences;
    }
}