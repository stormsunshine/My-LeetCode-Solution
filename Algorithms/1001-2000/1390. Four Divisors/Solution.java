class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += sumFourDivisors(num);
        return sum;
    }

    public int sumFourDivisors(int num) {
        if (num <= 5)
            return 0;
        if (isPrime(num))
            return 0;
        int sqrt = (int) Math.sqrt(num);
        int prime1 = 0, remain = 0;
        if (num % 2 == 0) {
            prime1 = 2;
            remain = num / 2;
        } else {
            for (int i = 3; i <= sqrt; i += 2) {
                if (num % i == 0) {
                    prime1 = i;
                    remain = num / i;
                    break;
                }
            }
        }
        if (prime1 > 0 && remain == prime1 * prime1 || remain > prime1 && isPrime(remain))
            return 1 + prime1 + remain + num;
        else
            return 0;
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