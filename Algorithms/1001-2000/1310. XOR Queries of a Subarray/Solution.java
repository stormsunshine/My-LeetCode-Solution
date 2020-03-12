class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int length = arr.length;
        int[] xors = new int[length];
        xors[0] = arr[0];
        for (int i = 1; i < length; i++)
            xors[i] = xors[i - 1] ^ arr[i];
        int queriesCount = queries.length;
        int[] result = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            int[] query = queries[i];
            int begin = query[0], end = query[1];
            if (begin == end)
                result[i] = arr[begin];
            else {
                if (begin == 0)
                    result[i] = xors[end];
                else
                    result[i] = xors[end] ^ xors[begin - 1];
            }
        }
        return result;
    }
}