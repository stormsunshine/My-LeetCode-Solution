class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        char lastLetter = letters[length - 1];
        if (lastLetter <= target)
            return letters[0];
        int index = binarySearch(letters, target);
        return letters[index];
    }

    public int binarySearch(char[] letters, char target) {
        target++;
        int low = 0, high = letters.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            char c = letters[mid];
            if (c == target)
                return mid;
            else if (c > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}