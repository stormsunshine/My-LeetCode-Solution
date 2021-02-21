class Solution {
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] leftBalls = new int[length];
        int[] rightBalls = new int[length];
        for (int i = 1; i < length; i++)
            leftBalls[i] = leftBalls[i - 1] + boxes.charAt(i - 1) - '0';
        for (int i = length - 2; i >= 0; i--)
            rightBalls[i] = rightBalls[i + 1] + boxes.charAt(i + 1) - '0';
        int[] leftOperations = new int[length];
        int[] rightOperations = new int[length];
        for (int i = 1; i < length; i++)
            leftOperations[i] = leftOperations[i - 1] + leftBalls[i];
        for (int i = length - 2; i >= 0; i--)
            rightOperations[i] = rightOperations[i + 1] + rightBalls[i];
        int[] operations = new int[length];
        for (int i = 0; i < length; i++)
            operations[i] = leftOperations[i] + rightOperations[i];
        return operations;
    }
}