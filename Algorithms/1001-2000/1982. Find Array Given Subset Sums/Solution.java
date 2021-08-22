class Solution {
    public int[] recoverArray(int n, int[] sums) {
        int total = 0;
        for (int num : sums)
            total += num;
        int sum = total / (1 << n - 1);
        Arrays.sort(sums);
        int[] arr = new int[n];
        List<Integer> sumsList = new ArrayList<Integer>();
        for (int num : sums)
            sumsList.add(num);
        List<Integer> small = new ArrayList<Integer>();
        List<Integer> large = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int size = sumsList.size();
            boolean[] selected = new boolean[size];
            int minNum = sumsList.get(1) - sumsList.get(0);
            boolean flag = false;
            for (int j = 0; j < size; j++) {
                if (!selected[j]) {
                    selected[j] = true;
                    small.add(sumsList.get(j));
                    for (int k = j + 1; k < size; k++) {
                        if (!selected[k] && sumsList.get(k) == sumsList.get(j) + minNum) {
                            selected[k] = true;
                            large.add(sumsList.get(k));
                            if (minNum == sumsList.get(k))
                                flag = true;
                            break;
                        }
                    }
                }
            }
            sumsList.clear();
            if (flag)
                sumsList = new ArrayList<Integer>(small);
            else {
                sumsList = new ArrayList<Integer>(large);
                minNum = -minNum;
            }
            small.clear();
            large.clear();
            arr[i] = minNum;
        }
        return arr;
    }
}