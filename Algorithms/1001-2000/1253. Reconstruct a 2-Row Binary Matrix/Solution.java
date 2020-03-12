class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        int sum = 0;
        int upperRemain = upper, lowerRemain = lower;
        for (int num : colsum) {
            sum += num;
            if (num == 2) {
                upperRemain--;
                lowerRemain--;
            }
        }
        if (sum != upper + lower || upperRemain < 0 || lowerRemain < 0)
            return matrix;
        for (int i = 0; i < 2; i++)
            matrix.add(new ArrayList<Integer>());
        int columns = colsum.length;
        for (int i = 0; i < columns; i++) {
            int curSum = colsum[i];
            if (curSum == 2) {
                matrix.get(0).add(1);
                matrix.get(1).add(1);
            } else if (curSum == 1) {
                if (upperRemain > 0) {
                    matrix.get(0).add(1);
                    matrix.get(1).add(0);
                    upperRemain--;
                } else {
                    matrix.get(0).add(0);
                    matrix.get(1).add(1);
                    lowerRemain--;
                }
            } else {
                matrix.get(0).add(0);
                matrix.get(1).add(0);
            }
        }
        return matrix;
    }
}