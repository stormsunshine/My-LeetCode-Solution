class Solution {
    public boolean gcdSort(int[] nums) {
        int maxNum = 100000;
        int[] parent = new int[maxNum + 1];
        boolean[] exists = new boolean[maxNum + 1];
        int length = nums.length;
        for (int i = 0; i < length; i++)
            exists[nums[i]] = true;
        for (int i = 1; i <= maxNum; i++)
            parent[i] = i;
        for (int i = 1; i <= maxNum; i++) {
            if (exists[i])
                divide(parent, i);
        }
        int[] sorted = new int[length];
        System.arraycopy(nums, 0, sorted, 0, length);
        Arrays.sort(sorted);
        for (int i = 0; i < length; i++) {
            if (find(parent, sorted[i]) != find(parent, nums[i]))
                return false;
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index)
            parent[index] = find(parent, parent[index]);
        return parent[index];
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }

    public void divide(int[] parent, int x) {
        int y = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                while (x % i == 0) {
                    x /= i;
                    union(parent, y, i);
                }
            }
        }
        if (x != 1)
            union(parent, y, x);
    }
}