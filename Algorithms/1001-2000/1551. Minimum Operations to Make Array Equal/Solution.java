class Solution {
    public int minOperations(int n) {
        int operations = 0;
        for (int i = n - 1; i > 0; i -= 2)
            operations += i;
        return operations;
    }
}