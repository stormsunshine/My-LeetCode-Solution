class Solution {
    public int minMoves(int[] nums, int k) {
        if (k == 1)
            return 0;
        List<Integer> indices = new ArrayList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1)
                indices.add(i);
        }
        int ones = indices.size();
        int differencesCount = ones - 1;
        int[] differences = new int[differencesCount];
        for (int i = 1; i < ones; i++)
            differences[i - 1] = indices.get(i) - indices.get(i - 1) - 1;
        int[] prefixSums = new int[differencesCount];
        prefixSums[0] = differences[0];
        for (int i = 1; i < differencesCount; i++)
            prefixSums[i] = prefixSums[i - 1] + differences[i];
        int[] postfixSums = new int[differencesCount];
        postfixSums[differencesCount - 1] = differences[differencesCount - 1];
        for (int i = differencesCount - 2; i >= 0; i--)
            postfixSums[i] = postfixSums[i + 1] + differences[i];
        int moves = getSum(differences, k);
        int minMoves = moves;
        int intervals = k - 1;
        for (int i = intervals; i < differencesCount; i++) {
            moves -= getPrefixSum(prefixSums, i - intervals, i - intervals + k / 2 - 1);
            moves += getPostfixSum(postfixSums, i - k / 2 + 1, i);
            minMoves = Math.min(minMoves, moves);
        }
        return minMoves;
    }

    public int getSum(int[] differences, int k) {
        int sum = 0;
        int left = 0, right = k - 2;
        while (left < right) {
            sum += (differences[left] + differences[right]) * (left + 1);
            left++;
            right--;
        }
        if (left == right)
            sum += differences[left] * (left + 1);
        return sum;
    }

    public int getPrefixSum(int[] prefixSums, int start, int end) {
        if (start == 0)
            return prefixSums[end];
        else
            return prefixSums[end] - prefixSums[start - 1];
    }

    public int getPostfixSum(int[] postfixSums, int start, int end) {
        if (end == postfixSums.length - 1)
            return postfixSums[start];
        else
            return postfixSums[start] - postfixSums[end + 1];
    }
}