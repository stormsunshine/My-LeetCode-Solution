class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            list.add(nums[i]);
        permutations.add(list);
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = nums[i];
        nextPermutation(array);
        while (!Arrays.equals(nums, array)) {
            List<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < length; i++)
                permutation.add(array[i]);
            permutations.add(permutation);
            nextPermutation(array);
        }
        return permutations;
    }

    public void nextPermutation(int[] array) {
        int length = array.length;
        int index = -1;
        int curNum = -1;
        for (int i = length - 1; i > 0; i--) {
            int difference = array[i] - array[i - 1];
            if (difference > 0) {
                index = i - 1;
                curNum = array[i - 1];
                break;
            }
        }
        if (index < 0) {
            Arrays.sort(array);
            return;
        }
        int nextIndex = -1;
        int nextNum = Integer.MAX_VALUE;
        for (int i = index + 1; i < length; i++) {
            if (array[i] > curNum && array[i] < nextNum) {
                nextIndex = i;
                nextNum = array[i];
            }
        }
        array[index] = nextNum;
        array[nextIndex] = curNum;
        Arrays.sort(array, index + 1, length);
    }
}