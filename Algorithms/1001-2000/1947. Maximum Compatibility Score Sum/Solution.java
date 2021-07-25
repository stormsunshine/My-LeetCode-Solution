class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = students[0].length;
        int[] studentsNums = new int[m];
        int[] mentorsNums = new int[m];
        for (int i = 0; i < m; i++) {
            studentsNums[i] = convertToNum(students[i]);
            mentorsNums[i] = convertToNum(mentors[i]);
        }
        int[] nums = new int[m];
        for (int i = 0; i < m; i++)
            nums[i] = i;
        int maxSum = 0;
        List<List<Integer>> permutations = permute(nums);
        for (List<Integer> permutation : permutations) {
            int sum = 0;
            for (int i = 0; i < m; i++)
                sum += n - Integer.bitCount(studentsNums[i] ^ mentorsNums[permutation.get(i)]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int convertToNum(int[] arr) {
        int num = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++)
            num += arr[i] << i;
        return num;
    }

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> permutation = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            permutation.add(nums[i]);
        backtrack(length, permutations, 0, permutation);
        return permutations;
    }

    public void backtrack(int length, List<List<Integer>> permutations, int start, List<Integer> permutation) {
        if (start == length)
            permutations.add(new ArrayList<Integer>(permutation));
        else {
            for (int i = start; i < length; i++) {
                Collections.swap(permutation, start, i);
                backtrack(length, permutations, start + 1, permutation);
                Collections.swap(permutation, start, i);
            }
        }
    }
}