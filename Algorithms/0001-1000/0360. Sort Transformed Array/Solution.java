class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0)
            return nums;
        int length = nums.length;
        int[] transformedArray = new int[length];
        if (a == 0) {
            int start = b >= 0 ? 0 : length - 1;
            int direction = b >= 0 ? 1 : -1;
            for (int i = 0, j = start; i < length; i++, j += direction)
                transformedArray[j] = b * nums[i] + c;
        } else {
            int index = a > 0 ? 0 : length - 1;
            int direction = a > 0 ? 1 : -1;
            double symmetryAxis = -b / (2.0 * a);
            int startIndex = binarySearch(nums, symmetryAxis);
            int index1 = startIndex >= 0 ? startIndex - 1 : -startIndex - 2;
            int index2 = startIndex >= 0 ? startIndex + 1 : -startIndex - 1;
            if (startIndex >= 0) {
                int num = nums[startIndex];
                transformedArray[index] = calculateQuadraticFunction(num, a, b, c);
                index += direction;
            }
            while (index1 >= 0 && index2 < length) {
                int value1 = calculateQuadraticFunction(nums[index1], a, b, c);
                int value2 = calculateQuadraticFunction(nums[index2], a, b, c);
                if ((value2 - value1) * direction >= 0) {
                    transformedArray[index] = value1;
                    index1--;
                } else {
                    transformedArray[index] = value2;
                    index2++;
                }
                index += direction;
            }
            while (index1 >= 0) {
                int value = calculateQuadraticFunction(nums[index1], a, b, c);
                transformedArray[index] = value;
                index1--;
                index += direction;
            }
            while (index2 < length) {
                int value = calculateQuadraticFunction(nums[index2], a, b, c);
                transformedArray[index] = value;
                index2++;
                index += direction;
            }
        }
        return transformedArray;
    }

    public int binarySearch(int[] nums, double key) {
        int low = 0, high = nums.length;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == key)
                return mid;
            else if (num > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }

    public int calculateQuadraticFunction(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}