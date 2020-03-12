class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : deck) {
            int count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
        }
        int gcd = 0;
        Set<Integer> keySet = countMap.keySet();
        for (int num : keySet) {
            int count = countMap.get(num);
            gcd = gcd(gcd, count);
        }
        return gcd >= 2;
    }

    public int gcd(int num1, int num2) {
        if (num1 == 0 && num2 == 0)
            return 1;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            num2 %= num1;
        }
        return num1 == 0 ? num2 : num1;
    }
}