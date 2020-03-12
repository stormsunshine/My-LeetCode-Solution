class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        int[] indices = {0, 0};
        while (low < high) {
            int num1 = numbers[low], num2 = numbers[high];
            int sum = num1 + num2;
            if (sum < target)
                low++;
            else if (sum > target)
                high--;
            else {
                indices[0] = low + 1;
                indices[1] = high + 1;
                break;
            }
        }
        return indices;
    }
}