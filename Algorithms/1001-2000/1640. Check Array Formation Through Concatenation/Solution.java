class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = arr.length;
        for (int i = 0; i < length; i++)
            map.put(arr[i], i);
        int[] flatPieces = new int[length];
        for (int[] piece : pieces) {
            int firstNum = piece[0];
            int index = map.getOrDefault(firstNum, -1);
            if (index < 0)
                return false;
            int curLength = piece.length;
            if (index + curLength > length)
                return false;
            System.arraycopy(piece, 0, flatPieces, index, curLength);
        }
        return Arrays.equals(arr, flatPieces);
    }
}