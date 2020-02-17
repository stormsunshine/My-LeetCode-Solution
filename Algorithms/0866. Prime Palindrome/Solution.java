class Solution {
    public int primePalindrome(int N) {
        int palindromeNum = nextPalindrome(N);
        while (!isPrime(palindromeNum))
            palindromeNum = nextPalindrome(palindromeNum + 1);
        return palindromeNum;
    }

    public int nextPalindrome(int num) {
        int length = String.valueOf(num).length();
        if (num + 1 == (int) Math.pow(10, length))
            return num + 2;
        int divisor = (int) Math.pow(10, length / 2);
        int headerNum = num / divisor;
        boolean even = length % 2 == 0;
        int palindromeNum = generatePalindrome(headerNum, even);
        if (palindromeNum < num)
            palindromeNum = generatePalindrome(headerNum + 1, even);
        return palindromeNum;
    }

    public int generatePalindrome(int num, boolean even) {
        StringBuffer sb1 = new StringBuffer(String.valueOf(num));
        StringBuffer sb2 = new StringBuffer(String.valueOf(num));
        sb2.reverse();
        if (!even)
            sb2.deleteCharAt(0);
        String palindromeStr = new StringBuffer(sb1.toString()).append(sb2.toString()).toString();
        return Integer.parseInt(palindromeStr);
    }

    public boolean isPrime(int num) {
        if (num == 1)
            return false;
        if (num == 2 || num == 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}