class Solution {
    public int minNumberOperations(int[] target) {
        int operations = 0;
        int prevHeight = 0;
        int length = target.length;
        for (int i = 0; i < length; i++) {
            int height = target[i];
            if (height > prevHeight)
                operations += height - prevHeight;
            prevHeight = height;
        }
        return operations;
    }
}