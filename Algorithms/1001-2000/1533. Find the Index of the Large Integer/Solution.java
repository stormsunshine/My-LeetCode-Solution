/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int rangeStart = 0, rangeEnd = reader.length() - 1;
        while (rangeStart < rangeEnd) {
            int rangeLength = rangeEnd - rangeStart + 1;
            int mid = (rangeEnd - rangeStart) / 2 + rangeStart;
            int l = rangeStart, r = rangeStart + rangeLength / 2 - 1, x = rangeEnd - rangeLength / 2 + 1, y = rangeEnd;
            int compare = reader.compareSub(l, r, x, y);
            if (compare == 0)
                return mid;
            else if (compare < 0)
                rangeStart = x;
            else
                rangeEnd = r;
        }
        return rangeStart;
    }
}