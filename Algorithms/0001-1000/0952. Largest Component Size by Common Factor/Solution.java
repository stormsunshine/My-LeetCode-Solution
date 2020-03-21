class Solution {
    public int largestComponentSize(int[] A) {
        int max = 0;
        for (int num : A)
            max = Math.max(max, num);
        int[] parents = new int[max + 1];
        for (int i = 0; i <= max; i++)
            parents[i] = i;
        for (int num : A) {
            int sqrt = (int) Math.sqrt(num);
            for (int i = 2; i <= sqrt; i++) {
                if (num % i == 0) {
                    union(parents, num, i);
                    union(parents, num, num / i);
                }
            }
        }
        int[] counts = new int[max + 1];
        int maxSize = 0;
        for (int num : A) {
            int ancestor = find(parents, num);
            counts[ancestor]++;
            maxSize = Math.max(maxSize, counts[ancestor]);
        }
        return maxSize;
    }

    public void union(int[] parents, int num1, int num2) {
        int ancestor1 = find(parents, num1);
        int ancestor2 = find(parents, num2);
        if (ancestor1 != ancestor2)
            parents[ancestor1] = ancestor2;
    }

    public int find(int[] parents, int num) {
        while (parents[num] != num) {
            parents[num] = parents[parents[num]];
            num = parents[num];
        }
        return num;
    }
}