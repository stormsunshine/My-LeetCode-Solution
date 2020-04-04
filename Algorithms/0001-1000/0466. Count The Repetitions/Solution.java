class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1 == null || s2 == null)
            return 0;
        int length1 = s1.length(), length2 = s2.length();
        if (length1 == 0 || length2 == 0 || n1 == 0 || n2 == 0)
            return 0;
        int gcd = gcd(n1, n2);
        n1 /= gcd;
        n2 /= gcd;
        int count = 0, index = 0;
        int[] counts = new int[length2 + 1];
        int[] indices = new int[length2 + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < length1; j++) {
                if (s1.charAt(j) == s2.charAt(index)) {
                    if (index == length2 - 1) {
                        count++;
                        index = 0;
                    } else
                        index++;
                }
            }
            counts[i] = count;
            indices[i] = index;
            for (int j = 0; j < i; j++) {
                if (indices[j] == index) {
                    int prevCount = counts[j];
                    int patternCount = (n1 - 1 - j) / (i - j) * (counts[i] - prevCount);
                    int remainCount = counts[j + (n1 - 1 - j) % (i - j)] - prevCount;
                    return (prevCount + patternCount + remainCount) / n2;
                }
            }
        }
        return counts[n1 - 1] / n2;
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