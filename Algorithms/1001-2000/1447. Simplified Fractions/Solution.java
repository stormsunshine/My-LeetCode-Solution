class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> fractions = new ArrayList<String>();
        if (n == 1)
            return fractions;
        fractions.add("1/2");
        for (int denominator = 3; denominator <= n; denominator++) {
            int maxNumerator = denominator / 2;
            for (int numerator = 1; numerator <= maxNumerator; numerator++) {
                if (gcd(numerator, denominator) == 1) {
                    fractions.add(numerator + "/" + denominator);
                    fractions.add((denominator - numerator) + "/" + denominator);
                }
            }
        }
        return fractions;
    }

    public int gcd(int num1, int num2) {
        if (num1 == 1)
            return 1;
        while (num1 != 0 && num2 != 0) {
            num2 %= num1;
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        return num2;
    }
}