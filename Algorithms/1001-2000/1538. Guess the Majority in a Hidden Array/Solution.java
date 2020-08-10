/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *   public:
 *     // Compares 4 different elements in the array
 *     // return 4 if the values of the 4 elements are the same (0 or 1).
 *     // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
 *     // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
 *     public int query(int a, int b, int c, int d);
 *
 *     // Returns the length of the array
 *     public int length();
 * };
 */

class Solution {
    public int guessMajority(ArrayReader reader) {
        int length = reader.length();
        int[] array = new int[length];
        array[0] = 0;
        int query0123 = reader.query(0, 1, 2, 3);
        int query0124 = reader.query(0, 1, 2, 4);
        int query0134 = reader.query(0, 1, 3, 4);
        int query0234 = reader.query(0, 2, 3, 4);
        int query1234 = reader.query(1, 2, 3, 4);
        array[1] = query0234 == query1234 ? 0 : 1;
        array[2] = query0134 == query1234 ? 0 : 1;
        array[3] = query0124 == query1234 ? 0 : 1;
        array[4] = query0123 == query1234 ? 0 : 1;
        int prev = query1234;
        for (int i = 5; i < length; i++) {
            int curr = reader.query(i - 3, i - 2, i - 1, i);
            array[i] = prev == curr ? array[i - 4] : 1 - array[i - 4];
            prev = curr;
        }
        int sum = 0;
        for (int num : array)
            sum += num;
        if (sum * 2 == length)
            return -1;
        else
            return sum * 2 < length ? findIndex(array, 0) : findIndex(array, 1);
    }

    public int findIndex(int[] array, int num) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] == num)
                return i;
        }
        return -1;
    }
}