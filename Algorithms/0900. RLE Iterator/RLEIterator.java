class RLEIterator {
    int[][] sequence;
    int length;
    int index;

    public RLEIterator(int[] A) {
        length = A.length / 2;
        index = 0;
        sequence = new int[length][2];
        for (int i = 0; i < length; i++) {
            sequence[i][0] = A[i * 2 + 1];
            sequence[i][1] = A[i * 2];
        }
    }
    
    public int next(int n) {
        while (index < length && sequence[index][1] == 0)
            index++;
        if (index == length)
            return -1;
        while (n > 0) {
            int exhaust = Math.min(n, sequence[index][1]);
            sequence[index][1] -= exhaust;
            n -= exhaust;
            if (n > 0 && sequence[index][1] == 0) {
                index++;
                if (index == length)
                    return -1;
            }
        }
        int num = sequence[index][0];
        return num;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */