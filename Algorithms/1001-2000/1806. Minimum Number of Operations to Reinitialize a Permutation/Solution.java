class Solution {
    public int reinitializePermutation(int n) {
        int[] init = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            init[i] = i;
            perm[i] = i;
        }
        int ops = 0;
        while (true) {
            ops++;
            update(n, perm);
            if (Arrays.equals(perm, init))
                break;
        }
        return ops;
    }

    public void update(int n, int[] perm) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                arr[i] = perm[i / 2];
            else
                arr[i] = perm[n / 2 + (i - 1) / 2];
        }
        System.arraycopy(arr, 0, perm, 0, n);
    }
}