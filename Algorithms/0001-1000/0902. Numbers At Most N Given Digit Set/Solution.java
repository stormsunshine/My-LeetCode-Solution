class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int counts = 0;
        int digitsCount = D.length;
        int length = String.valueOf(N).length();
        for (int i = 1; i < length; i++)
            counts += (int) Math.pow(digitsCount, i);
        for (int i = 1; i <= length; i++) {
            int curDigit = N / (int) Math.pow(10, length - i) % 10;
            int index = binarySearch(D, curDigit);
            if (index >= 0) {
                counts += index * (int) Math.pow(digitsCount, length - i);
                if (i == length)
                    counts++;
            } else {
                int curCount = (-index - 1) * (int) Math.pow(digitsCount, length - i);
                counts += curCount;
                break;
            }
        }
        return counts;
    }

    public int binarySearch(String[] digits, int target) {
        int low = 0, high = digits.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int digit = Integer.parseInt(digits[mid]);
            if (digit == target)
                return mid;
            else if (digit > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}